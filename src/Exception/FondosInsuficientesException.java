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
public class FondosInsuficientesException extends CuentaBancariaException{

    public FondosInsuficientesException() {
        super("Fondos insuficientes!");
    }

    public FondosInsuficientesException(String message) {
        super(message);
    }
    
}
