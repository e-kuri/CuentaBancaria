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
public class FormatoInvalidoException extends CuentaBancariaException{

    public FormatoInvalidoException() {
        super("Archivo con formato invalido");
    }

    public FormatoInvalidoException(String message) {
        super(message);
    }
 
    
    
}
