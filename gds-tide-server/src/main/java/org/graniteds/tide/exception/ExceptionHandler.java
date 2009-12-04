package org.graniteds.tide.exception;

import java.util.Map;

import org.granite.messaging.service.ExceptionConverter;
import org.granite.messaging.service.ServiceException;


public class ExceptionHandler implements ExceptionConverter {
    
    public boolean accepts(Throwable t) {
        //return emsg.faultCode == "Persistence.EntityNotFound"; // only accept EntityNotFound exception
        return true; // Accept every single exception...
    }

    public ServiceException convert(
        Throwable t, String detail, Map<String, Object> extendedData) {

    	System.err.println("--- "+t);
    	
        ServiceException se = new ServiceException(
            "AnyException", t.getMessage(), detail, t
        );
        se.getExtendedData().putAll(extendedData);
        return se;
    }
}