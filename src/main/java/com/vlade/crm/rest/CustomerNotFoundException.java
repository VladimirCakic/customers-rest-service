
package com.vlade.crm.rest;

/**
 *
 * @author Vladimir Cakic
 */
public class CustomerNotFoundException extends RuntimeException {


    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String msg) {
        super(msg);
    }
    
     public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }
     
      public CustomerNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
      
      public CustomerNotFoundException(String msg, Throwable cause, boolean enableSuppresion, 
              boolean writableStackTrace) {
        super(msg, cause, enableSuppresion, writableStackTrace);
    }
}
