package MpReportes.mcsvreportes.Controllers;

import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.Services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ReportesController {

    @Autowired
    private ReporteService reporteService;

//    @GetMapping("/api/reportes/all")
//    public String BuscarReportes( Model model){
//        model.addAttribute("reportes", reporteService.BuscaReportes());
//        return "index";
//    }


    @GetMapping("/index")
    public String Index(Model model) {
        Reportes reportes = new Reportes();
        model.addAttribute("reportes", reportes);
        return "index";
    }

    @PostMapping("/crear")
    public String guardarReporte(@ModelAttribute("reportes") Reportes reportes) {
        reporteService.guardarReporte(reportes);
        return "redirect:/index";
    }


}
