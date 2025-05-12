package com.aplication.canes.services.exceptions;

public class DataBaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;
	 
	public DataBaseException(Object id){
        super("Could not execute statement, Referential integrity constraint violation. " + id );
    }
}
