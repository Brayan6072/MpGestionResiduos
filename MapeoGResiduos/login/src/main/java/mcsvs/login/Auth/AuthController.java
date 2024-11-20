package mcsvs.login.Auth;

import ch.qos.logback.core.subst.Token;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import mcsvs.login.Client.ReportesClient;
import mcsvs.login.DTO.ReportesDTO;
import mcsvs.login.User.User;
import mcsvs.login.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;
    @Autowired
    private ReportesClient reportesClient;

    @GetMapping("/search-all-username")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }


}

//{
//        "username":"correo@gmail.com",
//        "password": "123456789",
//        "lastname":"hola",
//        "name": "hola",
//        "phone":"123456789"
//        }

//    @PostMapping(value = "/login")
//    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
//
//        return ResponseEntity.ok(authService.login(request));
//    }
//    @PostMapping(value = "/register")
//    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(authService.register(request));
//    }