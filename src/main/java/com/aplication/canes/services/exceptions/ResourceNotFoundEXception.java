package com.aplication.canes.services.exceptions;

public class ResourceNotFoundEXception extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundEXception(Object id){
        super("Resource not found id " + id);
    }
}
