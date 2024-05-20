package com.microservice.miniJuego.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class podiumController {

    @GetMapping("/podium")
    public String mostrarPodium() {
        return "podium";
    }
}