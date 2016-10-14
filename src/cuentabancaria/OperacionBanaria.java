/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import Exception.ClaveInvalidaException;
import Exception.FondosInsuficientesException;
import java.util.Date;

/**
 *
 * @author Dinorah Pacheco Reyes
 */
public class OperacionBanaria {
    
    
    private String claveOficina;
    private Date fechaOperacion;
    private Date fechaValor;
    private String UTC;
    private short claveDeberHaber;
    private double importe;
    private String noDocumento;
    private String referencua;
    private int noMovimiento;
    private CuentaBancaria cuenta;
    private String descripcion;
    //private double saldoPostOperacion;

    
    public OperacionBanaria(){
        descripcion = "";
    };
    
    public String getClaveOficina() {
        return claveOficina;
    }

    public void setClaveOficina(String claveOficina) {
        this.claveOficina = claveOficina;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public short getClaveDeberHaber() {
        return claveDeberHaber;
    }

    public void setClaveDeberHaber(short claveDeberHaber) throws ClaveInvalidaException {
        if(claveDeberHaber > 2 || claveDeberHaber < 1)
            throw new ClaveInvalidaException();
        this.claveDeberHaber = claveDeberHaber;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getReferencua() {
        return referencua;
    }

    public void setReferencua(String referencua) {
        this.referencua = referencua;
    }

    public int getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(int noMovimiento) {
        this.noMovimiento = noMovimiento;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(Date fechaValor) {
        this.fechaValor = fechaValor;
    }

    public String getUTC() {
        return UTC;
    }

    public void setUTC(String conceptopropio) {
        this.UTC = conceptopropio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void appendDescripcion(String descripcion){
        this.descripcion = this.descripcion + descripcion;
    }
/*
    public double getSaldoPostOperacion() {
        return saldoPostOperacion;
    }

    public void setSaldoPostOperacion(double saldoPostOperacion) {
        this.saldoPostOperacion = saldoPostOperacion;
    }
*/    
    
    
}
