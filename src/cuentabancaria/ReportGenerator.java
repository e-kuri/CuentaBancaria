/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Genera los reportes para las cuentas.
 * @author Dinorah Pacheco Reyes
 */
public class ReportGenerator {
    
    private Path file;
    
    public ReportGenerator(String path){
        file  = Paths.get(path);
    }
    
    /**
     * Genera el reporte de todas las cuentas
     * @param cuentas Mapa que contiene las cuentas sobre las que se creara el reporte.
     */
    public void createGeneralReport(Map<String, CuentaBancaria> cuentas){
        StringBuilder text = new StringBuilder(100);
        for(Map.Entry entry : cuentas.entrySet()){
            CuentaBancaria cuenta = (CuentaBancaria)entry.getValue();
            text.append("Numero de cuenta : " + entry.getKey());
            text.append("\nCuenta habiente: " + cuenta.getNombreTitular());
            text.append("\nSaldo inicial: " + cuenta.getSaldoInicial());
            text.append("\nSaldo final: " + cuenta.getSaldo());
            text.append("\nClave del banco: " + cuenta.getClaveBanco());
            text.append("\nClave de sucursal: " + cuenta.getClaveOficina());
            text.append("\nNumero de depositos: " + cuenta.getNumDepositos());
            text.append("\nMonto depositado: "+ cuenta.getCantidadDepositada());
            text.append("\nNumero de retiros: " + cuenta.getNumRetiros());
            text.append("\nMonto retirado: " + cuenta.getCantidadRetirada());
            text.append("\n\n");
        }
        Charset charset = Charset.forName("US-ASCII");
        try(BufferedWriter writer = Files.newBufferedWriter(file.resolve(Paths.get("reporte_general.txt")), charset)){
            writer.write(text.toString());
        }catch(IOException x){
            System.out.println("Ocurrio un error al escribir al archivo: " + x.getMessage());
        }
        System.out.println(text);
    }
    
    /**
     * Crea el reporte para una sola cuenta, con la informacion de las operaciones realizadas.
     * @param cuenta Cuenta bancaria sobre la que se creara el reporte.
     */
    public void createAccountReport(CuentaBancaria cuenta){
        StringBuilder text = new StringBuilder(100);
        List<OperacionBanaria> depositos;
        List<OperacionBanaria> retiros;
            depositos = new LinkedList<>();
            retiros = new LinkedList<>();
            
            for(OperacionBanaria op : cuenta.getOperaciones()){
                if(op.getClaveDeberHaber() == 1)
                    retiros.add(op);
                else
                    depositos.add(op);
            }
            
            text.append("Numero de cuenta : " + cuenta.getNoCuenta());
            text.append("\nCuenta habiente: " + cuenta.getNombreTitular());
            text.append("\nSaldo inicial: " + cuenta.getSaldoInicial());
            text.append("\nSaldo final: " + cuenta.getSaldo());
            text.append("\nClave del banco: " + cuenta.getClaveBanco());
            text.append("\nClave de sucursal: " + cuenta.getClaveOficina());
            text.append("\n\n\nDEPOSITOS:");
            
            for(OperacionBanaria op : depositos){
                text.append("\nReferencia: " + op.getReferencua());
                text.append("\nMonto: " + op.getImporte());
                text.append("\nDescripcion: " + op.getDescripcion());
                text.append("\n\n");
            }
            text.append("Numero de depositos: " + cuenta.getNumDepositos());
            text.append("Monto depositado: "+ cuenta.getCantidadDepositada());
            
            text.append("\n\n\nRETIROS:");
            
            for(OperacionBanaria op : retiros){
                text.append("\nReferencia: " + op.getReferencua());
                text.append("\nMonto: " + (op.getImporte() * -1));
                text.append("\nDescripcion:" + op.getDescripcion());
                text.append("\n\n");
            }
            
            text.append("Numero de retiros: " + cuenta.getNumRetiros());
            text.append("\nMonto retirado: " + cuenta.getCantidadRetirada());
            
        Charset charset = Charset.forName("US-ASCII");
        try(BufferedWriter writer = Files.newBufferedWriter(file.resolve(Paths.get("reporte_movimientos_"+cuenta.getNoCuenta()+".txt")), charset)){
            writer.write(text.toString());
        }catch(IOException x){
            System.out.println("Ocurrio un error al escribir al archivo: " + x.getMessage());
        }
        System.out.println(text);
    }
    
    /**
     * Crea los reportes para todas las cuentas recibidas en el mapa como parametro.
     * @param cuentas Mapa contenedor de las cuentas sobre las que se crearan los reportes.
     */
    public void createAllReports(Map<String, CuentaBancaria> cuentas){
        createGeneralReport(cuentas);
        for(Map.Entry entry : cuentas.entrySet()){
            createAccountReport((CuentaBancaria) entry.getValue());
        }
    }
    
}
