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

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;
    @Autowired
    private ReportesClient reportesClient;

//    @PostMapping(value = "/login")
//    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
//
//        return ResponseEntity.ok(authService.login(request));
//    }
    @PostMapping(value = "/login")
    public String login(LoginRequest request, Model model, Model token, String estatus){

        AuthResponse activo = authService.login(request);

        if(activo != null){
            estatus = "Rojo";
            token.addAttribute("useractivo", activo);
            System.out.println(activo);
            List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
            model.addAttribute("reportesList", reportesList);
            return "historial";
        }else{
            return "index";
        }

    }

//    @PostMapping(value = "/register")
//    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(authService.register(request));
//    }

    @PostMapping(value = "/register")
    public String register(RegisterRequest request, Model model, String estatus){

        authService.register(request);
        estatus = "Rojo";
        List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
        model.addAttribute("reportesList", reportesList);
        return "historial";
    }

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