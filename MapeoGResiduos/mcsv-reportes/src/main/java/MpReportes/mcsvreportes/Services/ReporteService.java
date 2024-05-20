package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.Entities.Reportes;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public interface ReporteService {

    List<Reportes> BuscaReportes();
    public Reportes guardarReporte(Reportes reportes);

}
