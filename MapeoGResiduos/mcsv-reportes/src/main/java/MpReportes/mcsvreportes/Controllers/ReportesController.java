package MpReportes.mcsvreportes.Controllers;

import MpReportes.mcsvreportes.Client.ReportesClient;
import MpReportes.mcsvreportes.DTO.UsernameDTO;
import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.Services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@CrossOrigin(origins = "https://mapeo-gestion-de-residuos.web.app/")
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    private ReporteService reporteService;
    @Autowired
    private ReportesClient reportesClient;

    @GetMapping("/index")
    public String Index(Model model) {
        Reportes reportes = new Reportes();
        model.addAttribute("reportes", reportes);
        return "index";
    }

    @PostMapping("/crear")
    public String guardarReporte(@ModelAttribute("reportes") Reportes reportes) {

        List<Reportes> reportexist = reporteService.findByClasificacionAndEstadoAndEstatusAndEtiquetau(reportes.getClasificacion(),reportes.getEstado(), reportes.getEstatus(), reportes.getEtiquetau());

        if(reportexist.isEmpty()){
            reporteService.guardarReporte(reportes);
            System.out.println(reportes);
            System.out.println("No repetido");
        }else{
            System.out.println("Repetido");

        }

        return "index";
    }

    @PostMapping("/reportar")
    public ResponseEntity<String> Reportar(@RequestBody Reportes reportes) {

        List<Reportes> reportexist = reporteService.findByClasificacionAndEstadoAndEstatusAndEtiquetau(
                reportes.getClasificacion(), reportes.getEstado(), reportes.getEstatus(), reportes.getEtiquetau()
        );

        if (reportexist.isEmpty()) {
            reporteService.guardarReporte(reportes);
            System.out.println(reportes);
            System.out.println("No repetido");
            return ResponseEntity.ok("Reporte guardado correctamente.");
        } else {
            System.out.println("Repetido");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Alguien más ha reportado el mismo contenedor");
        }
    }



    @GetMapping("/search-estatus/{estatus}")
    public ResponseEntity<?> findByEstatus(@PathVariable String estatus){
        return ResponseEntity.ok(reporteService.findAllReportes(estatus));
    }


    @GetMapping("/search-all-email")
    public ResponseEntity<?> getAllUsernames(){
        return ResponseEntity.ok(reportesClient.findAll());
    }

    @GetMapping("/getid/{id}")
    public  ResponseEntity<?> getId(@PathVariable Long id){
        return ResponseEntity.ok(reporteService.getId(id));
    }


    @GetMapping("/update/{id}")
    public ResponseEntity<?> UpdateEstatus(@PathVariable Long id){

        Reportes reportesExist = reporteService.getId(id);
        reportesExist.setEstatus("Verde");
        return ResponseEntity.ok(reporteService.updateEstatus(reportesExist));
    }
    @GetMapping("/CountLastWeek")
    public  ResponseEntity<?> CountLastWeek(){

        return ResponseEntity.ok(reporteService.countReportesInLastWeek());
    }
    @GetMapping("/CountLastMonth")
    public ResponseEntity<?> CountLastMonth(){
        return ResponseEntity.ok(reporteService.countReportesInLastMonth());
    }

}
