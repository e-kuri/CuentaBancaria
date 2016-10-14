/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import Exception.CuentaBancariaException;
import Exception.FormatoInvalidoException;
import java.util.Map;

/**
 *
 * @author Dinorah Pacheco Reyes
 */
public class Main {
    
    public static void main(String[] args) {
        FileParser fp = new FileParser("/Users/ekur0001/Downloads/InformacionBancaria.txt");
        ReportGenerator generator = new ReportGenerator("/Users/ekur0001/Desktop/cuentas");
        try{
            Map map = fp.parseBankAcounts();
            generator.createAllReports(map);
        }catch(CuentaBancariaException e){
            System.out.println(e.getMessage());
        }
    }
}
