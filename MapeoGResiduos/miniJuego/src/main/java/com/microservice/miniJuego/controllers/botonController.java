package com.microservice.miniJuego.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class botonController {

    @GetMapping("/mapa")
    public String mostrarMapa() {
        return "login";
    }

}