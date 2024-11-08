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
//Reportes del ultimo mes
    private List<Map<String, Object>> obtenerReportesMensuales() {
        List<Object[]> resultados = reportesClient.CountLastMonth();
        List<Map<String, Object>> reportesmonth = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Map<String, Object> reporte = new HashMap<>();
            reporte.put("clasificacion", resultado[0]);
            reporte.put("numero_reportes", resultado[1]);
            reportesmonth.add(reporte);
        }

        return reportesmonth;
    }
    //Reportes de la ultima semana
    private List<Map<String, Object>> obtenerReportesSemanal() {
        List<Object[]> resultados = reportesClient.CountLastWeek();
        List<Map<String, Object>> reportesweek = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Map<String, Object> reporte = new HashMap<>();
            reporte.put("clasificacion", resultado[0]);
            reporte.put("numero_reportes", resultado[1]);
            reportesweek.add(reporte);
        }

        return reportesweek;
    }

    @PostMapping(value = "/login")
    public String login(LoginRequest request, Model model, Model token, String estatus, Model modelm, Model models){

        AuthResponse activo = authService.login(request);

        if(activo != null){
            estatus = "Rojo";
            token.addAttribute("useractivo", activo);
            System.out.println(activo);
            List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
            model.addAttribute("reportesList", reportesList);

            List<Map<String, Object>> reportesmonth = obtenerReportesMensuales();
            modelm.addAttribute("reportesmes", reportesmonth);

            List<Map<String, Object>> reportesweek = obtenerReportesSemanal();
            models.addAttribute("reportessemanal", reportesweek);
            alert
            return "Historial";
        }else{
            return "index";
        }

    }


    @GetMapping("/search-estatus/{estatus}")
    public String getReportesByEstatus(@PathVariable String estatus, Model model, Model modelm, Model models) {
        estatus = "Rojo";
        List<ReportesDTO> reportesList = reportesClient.findByEstatus(estatus);
        model.addAttribute("reportesList", reportesList);

        List<Map<String, Object>> reportesmonth = obtenerReportesMensuales();
        modelm.addAttribute("reportesmes", reportesmonth);

        List<Map<String, Object>> reportesweek = obtenerReportesSemanal();
        models.addAttribute("reportessemanal", reportesweek);

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
    public String UpdateEstatus(@PathVariable Long id, Model model, Model modelm, Model models){
        ReportesDTO reportesDTO = reportesClient.updateEstatus(id);
        List<ReportesDTO> reportesList = reportesClient.findByEstatus("Rojo");
        model.addAttribute("reportesList", reportesList);

        List<Map<String, Object>> reportesmonth = obtenerReportesMensuales();
        modelm.addAttribute("reportesmes", reportesmonth);

        List<Map<String, Object>> reportesweek = obtenerReportesSemanal();
        models.addAttribute("reportessemanal", reportesweek);

        return "historial";
    }

    @GetMapping("/CountLastWeek")
    public List<Object[]> CountLastWeek(Model model){
        List<Object[]> reportlastweek = reportesClient.CountLastWeek();
        model.addAttribute("reportlastweek", reportlastweek);
        return reportlastweek;
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


        model.addAttribute("reportes", reportes);
        return "grafico";
    }

}
