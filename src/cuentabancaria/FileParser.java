/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ekur0001
 */
public class FileParser {
       
    Path file;
    
    public FileParser(String path){
        file = Paths.get(path);
    }
    
    public Map<String, CuentaBancaria> parseBankAcounts(){
        Charset charset = Charset.forName("US-ASCII");
        Map<String, CuentaBancaria> cuentas = new HashMap<>();
        try(InputStream in = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            String line;
            while((line = reader.readLine()) != null){
                CuentaBancaria currentAccount;
                switch(line.substring(0,2)){
                    case "11":
                        currentAccount = createAccountFromFile(line);
                        if(cuentas.containsKey(currentAccount.getNoCuenta()))
                            currentAccount = cuentas.get(currentAccount.getNoCuenta());
                        break;
                    case "22":
                        break;
                    case "23":
                        break;
                    case "33":
                        if(currentAccount != null)
                            cuentas.put(currentAccount.getNoCuenta(), currentAccount);
                        else
                            throw new IOException("Formato de archivo invalido");
                        break;
                    case "88":
                        break;
                }
            }
        }catch(IOException e){
            
        }
        return null;
    }
      
    private CuentaBancaria createAccountFromFile(String cabeceraCuenta){
        return null;
    }
    
}
