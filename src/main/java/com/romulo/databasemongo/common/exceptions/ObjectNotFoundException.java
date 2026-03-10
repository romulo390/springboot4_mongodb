package com.romulo.databasemongo.common.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String massage){
        super(massage);

    }
}
