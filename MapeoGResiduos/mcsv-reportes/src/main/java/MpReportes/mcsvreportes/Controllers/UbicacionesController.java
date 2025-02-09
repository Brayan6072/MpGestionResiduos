package MpReportes.mcsvreportes.Controllers;

import MpReportes.mcsvreportes.DTO.ContenedoresDTO;
import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.Services.UbicacionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contenedores/ubicaciones")
public class UbicacionesController {

    private final UbicacionServiceImpl ubicacionService;

    public UbicacionesController(UbicacionServiceImpl ubicacionService) {
        this.ubicacionService = ubicacionService;    }

    @GetMapping("/clasificaciones/{contenedornombre}")
    public ResponseEntity<?> clasificaciones(@PathVariable String contenedornombre){
        return ResponseEntity.ok(ubicacionService.findClasificacionesByContenedorNombre(contenedornombre));
    }

    @GetMapping("/clasificaciones")
    public ResponseEntity<?> getContenedoresConClasificaciones(){
        return ResponseEntity.ok(ubicacionService.getContenedoresConClasificaciones());
    }

    @GetMapping("/mapa")
    public String Mapa(){

        return "mapa";
    }

    @GetMapping("/reporte/{namecontenedor}")
    public String Reporte(@PathVariable String namecontenedor,Model model, Model etiqueta){
        List<Object[]> reporte = ubicacionService.findClasificacionesByContenedorNombre(namecontenedor);
        model.addAttribute("reporte", reporte);
        etiqueta.addAttribute("etiqueta", namecontenedor);
        return "reporte";
    }




}
