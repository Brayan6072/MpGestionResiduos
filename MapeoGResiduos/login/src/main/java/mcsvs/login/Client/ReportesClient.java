package mcsvs.login.Client;

import mcsvs.login.DTO.ContenedoresDTO;
import mcsvs.login.DTO.LocalizacionDTO;
import mcsvs.login.DTO.ReportesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "mcsv-reportes", url = "${feign.client.mcsv-reportes.url}")

public interface ReportesClient {

    @GetMapping("/reportes/search-estatus/{estatus}")
    List<ReportesDTO> findByEstatus(@PathVariable String estatus);

    @GetMapping("/reportes/update/{id}")
    ReportesDTO updateEstatus(@PathVariable Long id);

    @GetMapping("/reportes/CountLastWeek")
    List<Object[]> CountLastWeek();

    @GetMapping("/reportes/CountLastMonth")
    List<Object[]> CountLastMonth();

    @PostMapping("/contenedores/create")
    ResponseEntity<?> createContenedor(ContenedoresDTO contenedores);

    @GetMapping("/contenedores/get/{nombreContenedor}")
    Long findIdByNombre(@PathVariable String nombreContenedor);

    @PostMapping("/contenedores/ubicaciones/add")
    ResponseEntity<?> addContenedor(LocalizacionDTO localizacionDTO);

    }

