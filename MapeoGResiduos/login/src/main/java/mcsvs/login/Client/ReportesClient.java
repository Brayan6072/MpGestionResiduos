package mcsvs.login.Client;

import mcsvs.login.DTO.ReportesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mcsv-reportes", url = "${feign.client.mcsv-reportes.url}")

public interface ReportesClient {

    @GetMapping("/search-estatus/{estatus}")
    List<ReportesDTO> findByEstatus(@PathVariable String estatus);

    @GetMapping("/update/{id}")
    ReportesDTO updateEstatus(@PathVariable Long id);

    @GetMapping("/CountLastWeek")
    List<Object[]> CountLastWeek();

    @GetMapping("/CountLastMonth")
    List<Object[]> CountLastMonth();


}

