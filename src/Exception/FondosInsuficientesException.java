/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author ekur0001
 */
public class FondosInsuficientesException extends Exception{

    public FondosInsuficientesException() {
        super("Fondos insuficientes!");
    }

    public FondosInsuficientesException(String message) {
        super(message);
    }

    public FondosInsuficientesException(String message, Throwable cause) {
        super(message, cause);
    }

    public FondosInsuficientesException(Throwable cause) {
        super(cause);
    }
    
}
