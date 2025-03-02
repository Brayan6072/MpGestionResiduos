package MpReportes.mcsvreportes.Controllers;

import MpReportes.mcsvreportes.Entities.Contenedores;
import MpReportes.mcsvreportes.Services.ContenedorService;
import MpReportes.mcsvreportes.Services.ContenedorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contenedores")
public class ContenedorController {

    private final ContenedorServiceImpl contenedorService;

    public ContenedorController(ContenedorServiceImpl contenedorService) {
        this.contenedorService = contenedorService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContenedor(@RequestBody Contenedores contenedores){

        return ResponseEntity.ok(contenedorService.createContainer(contenedores));
    }

    @GetMapping("/get/{nombreContenedor}")
    public ResponseEntity<?> findIdByNombre(@PathVariable String nombreContenedor){
        return ResponseEntity.ok(contenedorService.findIdByNombre(nombreContenedor));
    }

}
