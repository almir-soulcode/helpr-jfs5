package org.soulcodeacademy.helpr.services.errors;

public class RecursosExcedidos extends RuntimeException{
    public RecursosExcedidos(String message){
        super(message);
    }
}
