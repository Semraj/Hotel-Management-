package com.lcwd.userservice.userservice.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resourse Not Found");

 //       String message="User Not found Exception";
//            public ResourceNotFoundException(message){
//                System.out.println(message);
//
//            }
    }

}
