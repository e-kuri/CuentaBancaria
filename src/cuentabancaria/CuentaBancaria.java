/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ekur0001
 */
public class CuentaBancaria {

    /**
     * @param args the command line arguments
     */
    
    public CuentaBancaria(){
        this.operaciones = new ArrayList<>();
    }
    
    private List<OperacionBanaria> operaciones;
    
    private String claveBanco, claveOficina, noCuenta;
    private Date fechaInicial, fechaFinal;
    private short claveDeberHaber;
    private double saldo;
    private short claveDivisa;
    private String nombreTitular;

    public void aplicarOperacion(OperacionBanaria operacion){
        this.operaciones.add(operacion);
    }
    
    public String getClaveBanco() {
        return claveBanco;
    }

    public void setClaveBanco(String claveBanco) {
        this.claveBanco = claveBanco;
    }

    public String getClaveOficina() {
        return claveOficina;
    }

    public void setClaveOficina(String claveOficina) {
        this.claveOficina = claveOficina;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public short getClaveDeberHaber() {
        return claveDeberHaber;
    }

    public void setClaveDeberHaber(short claveDeberHaber) {
        this.claveDeberHaber = claveDeberHaber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public short getClaveDivisa() {
        return claveDivisa;
    }

    public void setClaveDivisa(short claveDivisa) {
        if(claveDivisa != 484 || claveDivisa != 840)
            return;
        this.claveDivisa = claveDivisa;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
    
    
}
