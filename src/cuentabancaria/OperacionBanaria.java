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
 * @author ekur0001
 */
public class OperacionBanaria {
    
    
    private final int CODIGO_REGISTRO = 22;
    private int claveOficina;
    private Date fechaOperacion;
    private int conceptopropio;
    private short claveDeberHaber;
    private double importe;
    private int noDocumento;
    private String referencua;
    private int noMovimiento;
    private CuentaBancaria cuenta;

    /*
    public OperacionBanaria(int claveOficina, Date fechaOperacion, int conceptoPropio, short claveDeberHaber, double importe, int noDocumento, String referencua, int noMovimiento, CuentaBancaria cuenta) throws ClaveInvalidaException {
        this.claveOficina = claveOficina;
        this.fechaOperacion = fechaOperacion;
        this.conceptopropio = conceptoPropio;
        this.importe = importe;
        this.noDocumento = noDocumento;
        this.referencua = referencua;
        this.noMovimiento = noMovimiento;
        this.cuenta = cuenta;
        setClaveDeberHaber(claveDeberHaber);
    }
*/
    
    public OperacionBanaria(){};

    public int getClaveOficina() {
        return claveOficina;
    }

    public void setClaveOficina(int claveOficina) {
        this.claveOficina = claveOficina;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public int getConceptoPropio() {
        return conceptopropio;
    }

    public void setConceptoPropio(int conceptoPropio) {
        this.conceptopropio = conceptoPropio;
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

    public int getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(int noDocumento) {
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
    
    
}
