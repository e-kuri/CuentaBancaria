/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import Exception.ClaveInvalidaException;
import Exception.FormatoInvalidoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dinorah Pacheco Reyes
 */
public class FileParser {
       
    private Path file;
    
    public FileParser(String path){
        file = Paths.get(path);
    }
    /**
     * Genera un mapa con las cuentas generadas a partir del archivo txt. La llave de cada registro es el numero de cuenta.
     * @return Mapa con las cuentas generadas en el registro.
     * @throws FormatoInvalidoException Si el archivo de texto no tiene el formato especificado.
     */
    public Map<String, CuentaBancaria> parseBankAcounts() throws FormatoInvalidoException{
        Charset charset = Charset.forName("US-ASCII");
        Map<String, CuentaBancaria> cuentas = new HashMap<>()
                ;
        try(InputStream in = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            String line;
            CuentaBancaria currentAccount = null;
            while((line = reader.readLine()) != null){
                switch(line.substring(0,2)){
                    case "11":
                        currentAccount = createAccountFromFile(line);
                        break;
                    case "22":
                        currentAccount.aplicarOperacion(createOperacionFromFile(line));
                        break;
                    case "23":
                        currentAccount.getLastOperation().appendDescripcion(getDescripcion(line));
                        break;
                    case "33":
                        if(currentAccount != null)
                            cuentas.put(currentAccount.getNoCuenta(), currentAccount);
                        else
                            throw new FormatoInvalidoException();
                        break;
                    case "88":
                        break;
                }
            }
        }catch(IOException e){
            throw new FormatoInvalidoException();
        }
        return cuentas;
    }
      
    /**
     * Genera una cuenta bancaria a partir del registro de cabecera de cuenta
     * @param cabeceraCuenta Registro de cabecera de cuenta
     * @return cuenta bancaria generada
     * @throws FormatoInvalidoException Si el archivo no tiene el formato especificado
     */
    private CuentaBancaria createAccountFromFile(String cabeceraCuenta) throws FormatoInvalidoException{
        DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        CuentaBancaria cuenta = new CuentaBancaria();
        short claveDeberHaber;
        int currentIndex = 10;
        try{
            cuenta.setClaveBanco(cabeceraCuenta.substring(currentIndex, (currentIndex += 3)));
            cuenta.setClaveOficina(cabeceraCuenta.substring(++currentIndex, (currentIndex+=4)));
            cuenta.setNoCuenta(cabeceraCuenta.substring((currentIndex += 7), (currentIndex+=10)));
            
                
            cuenta.setFechaInicial(dateFormat.parse(cabeceraCuenta.substring(currentIndex, (currentIndex += 6))));
            cuenta.setFechaFinal(dateFormat.parse(cabeceraCuenta.substring(currentIndex, (currentIndex += 6))));
            claveDeberHaber = Short.parseShort(cabeceraCuenta.substring(currentIndex, ++currentIndex));
           
            StringBuilder saldoInicialBuilder = new StringBuilder(14);
            saldoInicialBuilder.append(cabeceraCuenta.substring(currentIndex, (currentIndex += 12)))
                    .append(".").append(cabeceraCuenta.substring(currentIndex, (currentIndex += 2)));
            
            cuenta.setSaldoInicial(Double.parseDouble(saldoInicialBuilder.toString()));
            if(claveDeberHaber == 1)
                cuenta.setSaldoInicial(cuenta.getSaldoInicial()*-1);
            cuenta.setClaveDivisa(Short.parseShort(cabeceraCuenta.substring(currentIndex, (currentIndex += 3))));
            cuenta.setNombreTitular(cabeceraCuenta.substring(++currentIndex, (currentIndex += 26)));
            
        }catch(IndexOutOfBoundsException | ParseException | ClaveInvalidaException e){
            throw new FormatoInvalidoException(e.getMessage());
        }
        return cuenta;
    }
    
    /**
     * Genera una operacion bancaria a partir del registro principal de movimientos
     * @param texto registro principal de movimientos
     * @return operacion bancaria generada
     * @throws FormatoInvalidoException Si el formato del documento no coincide con el especificado
     */
    private OperacionBanaria createOperacionFromFile(String texto) throws FormatoInvalidoException{
        OperacionBanaria operacion = new OperacionBanaria();
        DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        short claveDeberHaber;
        int currentIndex = 6;
        try{
            operacion.setClaveOficina(texto.substring(currentIndex, (currentIndex += 4)));
            operacion.setFechaOperacion(dateFormat.parse(texto.substring(currentIndex, (currentIndex += 6))));
            operacion.setFechaValor(dateFormat.parse(texto.substring(currentIndex, (currentIndex += 6))));
            operacion.setUTC(texto.substring(++currentIndex, (currentIndex += 4)));
            claveDeberHaber = Short.parseShort(texto.substring(currentIndex, ++currentIndex));
            
            StringBuilder importeBuilder = new StringBuilder(14);
            importeBuilder.append(texto.substring(currentIndex, (currentIndex += 12)))
                    .append(".").append(texto.substring(currentIndex, (currentIndex += 2)));
            
            operacion.setImporte(Double.parseDouble(importeBuilder.toString()));
            if(claveDeberHaber == 1){
                operacion.setImporte(operacion.getImporte() * -1);
            }
            operacion.setNoDocumento(texto.substring(currentIndex, (currentIndex += 10)).trim());
            operacion.setReferencua(texto.substring(currentIndex, currentIndex+=30));
        }catch(IndexOutOfBoundsException | ParseException e){
            throw new FormatoInvalidoException(e.getMessage());
        }
        
        return operacion;
    }
    
    private String getDescripcion(String registro){
        String descripcion;
        return registro.substring(4, registro.length()).trim();
    }
    
}
