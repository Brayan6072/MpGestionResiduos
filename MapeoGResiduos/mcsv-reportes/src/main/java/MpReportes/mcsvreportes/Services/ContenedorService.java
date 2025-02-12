package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.Entities.Contenedores;
import MpReportes.mcsvreportes.Entities.LocalizacionContenedores;
import MpReportes.mcsvreportes.Entities.Reportes;
import org.springframework.data.repository.query.Param;

public interface ContenedorService {
    Contenedores createContainer(Contenedores contenedores);
    Long findIdByNombre(String nombreContenedor);
}
