package me.noitcereon.exceptions;

public class InternalApplicationException extends RuntimeException{
    public InternalApplicationException(){
        super();
    }
    public InternalApplicationException(String exceptionMessage){
        super(exceptionMessage);
    }
    public InternalApplicationException(Exception e){
        super(e);
    }
}
