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
public class ClaveInvalidaException extends CuentaBancariaException{

    public ClaveInvalidaException() {
        super("Clave invalida. La clave deber-haber debe ser 0 o 1.");
    }

    public ClaveInvalidaException(String message) {
        super(message);
    }    
    
}
