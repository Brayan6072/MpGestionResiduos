package com.microservice.miniJuego.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class botonController {

    @GetMapping("/mapa")
    public String mostrarMapa() {
        return "login";
    }

}