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
    
    private static void printMovements(Map<String, CuentaBancaria> cuentas){
        for(Map.Entry entry : cuentas.entrySet()){
            System.out.println("\n\n");
            CuentaBancaria cuenta = (CuentaBancaria)entry.getValue();
            System.out.println("Numero de cuenta : " + entry.getKey());
            System.out.println("Cuenta habiente: " + cuenta.getNombreTitular());
            System.out.println("Saldo inicial: " + cuenta.getSaldoInicial());
            System.out.println("Saldo final: " + cuenta.getSaldo());
            System.out.println("Clave del banco: " + cuenta.getClaveBanco());
            System.out.println("Clave de sucursal: " + cuenta.getClaveOficina());
            System.out.println("Numero de depositos: " + cuenta.getNumDepositos());
            System.out.println("Monto depositado: "+ cuenta.getCantidadDepositada());
            System.out.println("Numero de retiros: " + cuenta.getNumRetiros());
            System.out.println("Monto retirado: " + cuenta.getCantidadRetirada());
        }
    }
    
    public static void main(String[] args) {
        FileParser fp = new FileParser("/Users/ekur0001/Downloads/InformacionBancaria.txt");
        Map map = null;
        try{
            map = fp.parseBankAcounts();
        }catch(CuentaBancariaException e){
            System.out.println(e.getMessage());
        }
        printMovements(map);
    }
}
