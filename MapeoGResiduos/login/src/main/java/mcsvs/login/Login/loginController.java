package mcsvs.login.Login;

import lombok.RequiredArgsConstructor;
import mcsvs.login.Auth.AuthResponse;
import mcsvs.login.Auth.AuthService;
import mcsvs.login.Auth.LoginRequest;
import mcsvs.login.Client.ReportesClient;
import mcsvs.login.DTO.ReportesDTO;
import mcsvs.login.User.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class loginController {
    private final ReportesClient reportesClient;
    private final AuthService authService;
    private final UserRepository userRepository;


    @PostMapping(value = "/login")
    public String login(LoginRequest request, Model model, Model token, String estatus){

        AuthResponse activo = authService.login(request);

        if(activo != null){
            estatus = "Rojo";
            token.addAttribute("useractivo", activo);
            System.out.println(activo);
            List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
            model.addAttribute("reportesList", reportesList);
            return "Historial";
        }else{
            return "index";
        }

    }

    @GetMapping(value = "/dashboard")
    public String welcome(String estatus, Model model)
    {
        estatus = "Rojo";
        List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
        model.addAttribute("reportesList", reportesList);

        return "historial";
    }



    @GetMapping("/search-estatus/{estatus}")
    public String getReportesByEstatus(@PathVariable String estatus, Model model) {
        estatus = "Rojo";
        List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
        model.addAttribute("reportesList", reportesList);

        return "historial";
    }
    @GetMapping("/search-registro/{estatus}")
    public String getRegistroByEstatus(@PathVariable String estatus, Model model) {
        estatus = "Verde";
        List<ReportesDTO> registroList = reportesClient.findByEstatus(estatus);
        model.addAttribute("registroList", registroList);
        return "Registro";
    }
    @GetMapping("/update/{id}")
    public String UpdateEstatus(@PathVariable Long id, Model model){
        ReportesDTO reportesDTO = reportesClient.updateEstatus(id);
        List<ReportesDTO> reportesList = reportesClient.findByEstatus("Rojo");
        model.addAttribute("reportesList", reportesList);
        return "historial";
    }


}
