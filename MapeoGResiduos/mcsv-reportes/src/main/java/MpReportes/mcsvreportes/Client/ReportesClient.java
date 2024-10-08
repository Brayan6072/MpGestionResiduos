package MpReportes.mcsvreportes.Client;

import MpReportes.mcsvreportes.DTO.UsernameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mcsv-login", url = "localhost:9090/auth")
public interface ReportesClient {

    @GetMapping("/search-all-username")
    List<UsernameDTO> findAll();


}
