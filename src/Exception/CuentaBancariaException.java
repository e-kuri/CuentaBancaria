/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Dinorah Pacheco Reyes
 */
public abstract class CuentaBancariaException extends Exception{

    public CuentaBancariaException() {
    }

    public CuentaBancariaException(String message) {
        super(message);
    }
    
}
