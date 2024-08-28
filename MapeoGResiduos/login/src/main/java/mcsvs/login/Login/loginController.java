package mcsvs.login.Login;

import lombok.RequiredArgsConstructor;
import mcsvs.login.Client.ReportesClient;
import mcsvs.login.DTO.ReportesDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class loginController {
    private final ReportesClient reportesClient;
    @GetMapping(value = "dashboard")
    public String welcome()
    {
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
