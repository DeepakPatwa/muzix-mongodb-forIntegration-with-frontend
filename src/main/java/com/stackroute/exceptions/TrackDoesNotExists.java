package com.stackroute.exceptions;

public class TrackDoesNotExists extends Exception{
    String message;
    public TrackDoesNotExists(){

    }

    public TrackDoesNotExists(String message)
    {
        super(message);
        this.message=message;
    }
}
