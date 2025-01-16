package MpReportes.mcsvreportes.Controllers;

import MpReportes.mcsvreportes.DTO.ContenedoresDTO;
import MpReportes.mcsvreportes.Services.UbicacionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contenedores/ubicaciones")
public class UbicacionesController {

    private final UbicacionServiceImpl ubicacionService;

    public UbicacionesController(UbicacionServiceImpl ubicacionService) {
        this.ubicacionService = ubicacionService;    }
/*
    @GetMapping("/clasificaciones/{contenedornombre}")
    public ResponseEntity<?> clasificaciones(@PathVariable String contenedornombre){
        return ResponseEntity.ok(ubicacionService.findClasificacionesByContenedorNombre(contenedornombre));
    }*/

    @GetMapping("/clasificaciones")
    public ResponseEntity<?> getContenedoresConClasificaciones(){
        return ResponseEntity.ok(ubicacionService.getContenedoresConClasificaciones());
    }
}
