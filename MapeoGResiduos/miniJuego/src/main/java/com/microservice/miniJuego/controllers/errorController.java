package com.microservice.miniJuego.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorController {
    @GetMapping("/error")
    public String handleError() {
        // Lógica para manejar el error, por ejemplo, devolver una vista de error personalizada
        return "error";
    }
}
