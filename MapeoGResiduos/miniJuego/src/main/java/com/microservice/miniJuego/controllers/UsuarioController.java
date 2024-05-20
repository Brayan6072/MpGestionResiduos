package com.microservice.miniJuego.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.microservice.miniJuego.models.UsuarioRequest;

import java.util.UUID;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UsuarioController {

    @PostMapping("/api/crearUsuario")
    public String crearUsuario(@RequestBody UsuarioRequest usuarioRequest, HttpSession session) {
        Firestore db = FirestoreClient.getFirestore();

        String userId = UUID.randomUUID().toString();
        usuarioRequest.setUserId(userId);

        try {
            db.collection("usuarios").document(userId).set(usuarioRequest);
            
            session.setAttribute("userId", userId);
            
            return "Usuario creado exitosamente";
        } catch(Exception e) {
            e.printStackTrace();
            return "Error al crear usuario";
        }
    }
}
