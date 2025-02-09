package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.DTO.ContenedoresDTO;
import MpReportes.mcsvreportes.Entities.LocalizacionContenedores;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UbicacionService {

    List<Object[]> findClasificacionesByContenedorNombre(String contenedorNombre);
    List<Object[]> getContenedoresConClasificaciones();
}
