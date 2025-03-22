package MpReportes.mcsvreportes.Controllers;

import MpReportes.mcsvreportes.DTO.LocalizacionDTO;
import MpReportes.mcsvreportes.Entities.LocalizacionContenedores;
import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.Services.ContenedorServiceImpl;
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
    private final ContenedorServiceImpl contenedorService;

    public UbicacionesController(UbicacionServiceImpl ubicacionService, ContenedorServiceImpl contenedorService) {
        this.ubicacionService = ubicacionService;
        this.contenedorService = contenedorService;

    }

    @GetMapping("/clasificaciones")
    public ResponseEntity<?> getContenedoresConClasificaciones(){
        return ResponseEntity.ok(ubicacionService.getContenedoresConClasificaciones());
    }

    @GetMapping("/mapa")
    public String Mapa( ){

        return "mapa";
    }

    @GetMapping("/reporte/{namecontenedor}")
    public String Reporte(@PathVariable String namecontenedor,Model contenedores, Model etiqueta, @ModelAttribute("reportes") Reportes reportes){
        List<Object[]> contenedor = ubicacionService.findClasificacionesByContenedorNombre(namecontenedor);
        contenedores.addAttribute("contenedores", contenedor);
        etiqueta.addAttribute("etiqueta", namecontenedor);

        return "reporte";
    }

    @GetMapping("/clasificaciones/{contenedornombre}")
    public ResponseEntity<?> clasificaciones(@PathVariable String contenedornombre){
        return ResponseEntity.ok(ubicacionService.findClasificacionesByContenedorNombre(contenedornombre));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLocalizacion(@RequestBody LocalizacionContenedores localizacionContenedores){
        return ResponseEntity.ok(ubicacionService.createLocalizacion(localizacionContenedores));

    }

    @PostMapping("/add")
    public ResponseEntity<?> addContenedor(@RequestBody LocalizacionDTO localizacionDTO){
        return ResponseEntity.ok(ubicacionService.addLocation(localizacionDTO));
    }

    @PostMapping("/deleteUbicacion/{contenedor_id}")
    public ResponseEntity<?> deleteUbicacion(@PathVariable int contenedor_id){
        ubicacionService.deleteByContenedor_id(contenedor_id);
        return ResponseEntity.ok(contenedorService.deleteById(contenedor_id));

    }


    /*
    {
        "id": 83,
        "contenedores": {
            "id": 24,
            "nombre": null,
            "longitud": null,
            "latitud": null
        },
        "clasificaciones": {
            "id": 1,
            "nombre": null
        }
    }
    */

}
