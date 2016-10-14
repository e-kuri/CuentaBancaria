/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import Exception.ClaveInvalidaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dinorah Pacheco Reyes
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
    private double saldo;
    private short claveDivisa;
    private String nombreTitular;
    private final short modalidadDeInformacion = 3;
    private double saldoInicial;
    private int numDepositos;
    private double cantidadDepositada;
    private int numRetiros;
    private double cantidadRetirada;

    public void aplicarOperacion(OperacionBanaria operacion){
        this.saldo = this.saldo + operacion.getImporte();
        //operacion.setSaldoPostOperacion(this.saldo);
        operacion.setCuenta(this);
        this.operaciones.add(operacion);
        
        if(operacion.getImporte() < 0){
            numRetiros++;
            cantidadRetirada += operacion.getImporte() * -1;
        }else{
            numDepositos++;
            cantidadDepositada += operacion.getImporte();
        }
            
    }
    
    public OperacionBanaria getLastOperation(){
        return operaciones.get(operaciones.size() - 1);
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
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public short getClaveDivisa() {
        return claveDivisa;
    }

    public void setClaveDivisa(short claveDivisa) throws ClaveInvalidaException {
        if(claveDivisa != 484 && claveDivisa != 840)
            throw new ClaveInvalidaException("La clave divisa debe ser 484 o 840");
        this.claveDivisa = claveDivisa;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public List<OperacionBanaria> getOperaciones() {
        return operaciones;
    }

    public short getModalidadDeInformacion() {
        return modalidadDeInformacion;
    }
    
    public double getSaldoInicial(){
        return this.saldoInicial;
    }
    
    public void setSaldoInicial(double saldoInicial){
        this.saldoInicial = saldoInicial;
        this.saldo = saldoInicial;
    }

    public int getNumDepositos() {
        return numDepositos;
    }

    public double getCantidadDepositada() {
        return cantidadDepositada;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public double getCantidadRetirada() {
        return cantidadRetirada;
    }
    
}
