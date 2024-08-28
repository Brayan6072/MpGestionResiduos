package com.microservice.miniJuego.services;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInicializacion {

    @PostConstruct
    public void inicializacion() throws FileNotFoundException{

        FileInputStream serviceAccount =
                    null;
         try {         
            serviceAccount = new FileInputStream("C:\\Users\\ben10\\OneDrive\\Escritorio\\MapeoGResiduos\\miniJuego\\serviceAccountKey.json");

        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        

        FirebaseApp.initializeApp(options);
            } catch (IOException e) {
                 e.printStackTrace();
         }
    }

}
