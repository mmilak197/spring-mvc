package com.mmilak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice //kontroller globalny który jest głownym kontrolerem najpierw żadanie trafia do niego a potem do innych kontrollerów
public class ExceptionController {


    @ExceptionHandler(Exception.class)  //łapiemy wszystkie wyjatki które wystąpiły w programie
    public String hadleException(Exception e) {

        e.getMessage();
        return "handleException";   //zwrócenie strony odpowiedniej strony w przypadku napotkania błedu
    }
}
