package com.microservice.miniJuego.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import jakarta.servlet.http.HttpSession;

@RestController
public class TirarBasuraController {

    @PostMapping("/tirarBasura")
    public String tirarBasura(HttpSession session) {
        Firestore db = FirestoreClient.getFirestore();

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            String mensaje = "Error: Usuario no encontrado en la sesión.";
                System.out.println(mensaje);
                
        }

        try {
            @SuppressWarnings("null")
            DocumentReference usuarioRef = db.collection("usuarios").document(userId);
            ApiFuture<DocumentSnapshot> future = usuarioRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                @SuppressWarnings("null")
                int puntosActuales = document.getLong("puntos").intValue();
                usuarioRef.update("puntos", puntosActuales + 5);

                String mensaje = "Tiraste basura con éxito. Se te han otorgado 5 puntos.";
                System.out.println(mensaje);
                return mensaje;
            } else {
                String mensaje = "Error: No se encontró al usuario en Firebase.";
                System.out.println(mensaje);
                return mensaje;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al tirar basura.";
        }
    }
}
