package mcsvs.login.Login;

import lombok.RequiredArgsConstructor;
import mcsvs.login.Auth.AuthResponse;
import mcsvs.login.Auth.AuthService;
import mcsvs.login.Auth.LoginRequest;
import mcsvs.login.Client.ReportesClient;
import mcsvs.login.DTO.ReportesDTO;
import mcsvs.login.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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

    @GetMapping("/CountLastWeek")
    public List<Object[]> CountLastWeek(Model model){
        List<Object[]> reportlastweek = reportesClient.CountLastWeek();
        model.addAttribute("reportlastweek", reportlastweek);
        return reportlastweek;
    }

    @GetMapping("/CountLastMonth")
    public String CountLastMonth(Model model){
        List<Object[]> reportlastmonth = reportesClient.CountLastMonth();
        model.addAttribute("reportlastmonth", reportlastmonth);
        return "piechart";
    }
    @GetMapping("/reportes")
    public String mostrarGrafico(Model model) {

        List<Object[]> resultados = reportesClient.CountLastMonth();

        List<Map<String, Object>> reportes = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Map<String, Object> reporte = new HashMap<>();
            reporte.put("clasificacion", resultado[0]);
            reporte.put("numero_reportes", resultado[1]);
            reportes.add(reporte);
        }

        // Agrega los reportes al modelo
        model.addAttribute("reportes", reportes);
        return "grafico";  // Nombre de la plantilla Thymeleaf que se va a renderizar
    }

}
