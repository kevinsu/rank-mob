package com.rankmob.service.exception;

import javax.xml.ws.WebServiceException;

public class UserExistsException extends WebServiceException {
    public UserExistsException(String message) {
        super(message);
    }
}
