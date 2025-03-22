package mcsvs.login.Login;

import lombok.RequiredArgsConstructor;
import mcsvs.login.Auth.AuthResponse;
import mcsvs.login.Auth.AuthService;
import mcsvs.login.Auth.LoginRequest;
import mcsvs.login.Auth.RegisterRequest;
import mcsvs.login.Client.ReportesClient;
import mcsvs.login.DTO.ContenedoresDTO;
import mcsvs.login.DTO.LocalizacionDTO;
import mcsvs.login.DTO.ReportesDTO;
import mcsvs.login.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
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
    public String login(LoginRequest request, Model model,Model tokenactivo, Model login) {

        login.addAttribute("login", request);

        AuthResponse activo = authService.login(request);
        tokenactivo.addAttribute("token", activo);
        System.out.println(activo);

        if (activo != null) {

            return "redirect:/api/v1/search-estatus/Rojo";
        } else {
            return "index";
        }
    }

    @GetMapping("/inicio")
    public ResponseEntity<?> Inicio(@RequestBody LoginRequest request){

       return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/register")
    public String register(RegisterRequest request,Model register){

        register.addAttribute("register", request);
        authService.register(request);

        return "redirect:/api/v1/search-estatus/Rojo";

    }

    @GetMapping("/Signout")
    public String signout (Model login, Model register){
        LoginRequest request = new LoginRequest();
        login.addAttribute("request", request);

        RegisterRequest response = new RegisterRequest();
        register.addAttribute("register", response);

        return "index";
    }


    @GetMapping("/search-estatus/Rojo")
    public String getReportesByEstatus(Model model, Model modelm, Model models) {

        List<ReportesDTO> reportesList = reportesClient.findByEstatus("Rojo");
        model.addAttribute("reportesList", reportesList);

        List<Map<String, Object>> reportesmonth = obtenerReportesMensuales();
        modelm.addAttribute("reportesmes", reportesmonth);

        List<Map<String, Object>> reportesweek = obtenerReportesSemanal();
        models.addAttribute("reportessemanal", reportesweek);

        return "historial";
    }

    @GetMapping("/search-registro/Verde")
    public String getRegistroByEstatus(Model model) {

        List<ReportesDTO> registroList = reportesClient.findByEstatus("Verde");
        model.addAttribute("registroList", registroList);
        return "Registro";
    }

    @GetMapping("/update/{id}")
    public String UpdateEstatus(@PathVariable Long id){
        ReportesDTO reportesDTO = reportesClient.updateEstatus(id);

        return "redirect:/api/v1/search-estatus/Rojo";
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


    @PostMapping("/addContenedores")
    public String agregarLocalizacion(@ModelAttribute("contenedores") ContenedoresDTO contenedores, @ModelAttribute("localizacionDTO") LocalizacionDTO localizacionDTO){

        reportesClient.createContenedor(contenedores);
        System.out.println(contenedores);

        Long id = reportesClient.findIdByNombre(contenedores.getNombre());
        System.out.println(id);

        localizacionDTO.setContenedor_id(id);
        System.out.println(localizacionDTO);

        reportesClient.addContenedor(localizacionDTO);
        return "redirect:/api/v1/form";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@ModelAttribute("contenedores") ContenedoresDTO contenedores, @ModelAttribute("localizacionDTO") LocalizacionDTO localizacionDTO, Model containers) {
        List<ContenedoresDTO> contenedoresDTO = reportesClient.findContainers();
        containers.addAttribute("containers", contenedoresDTO);

        return "crearUbicacion";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam int contenedor_id) {
        model.addAttribute("contenedor_id", contenedor_id);
        reportesClient.deleteUbicacion(contenedor_id);
        return "redirect:/api/v1/form";
    }

}
