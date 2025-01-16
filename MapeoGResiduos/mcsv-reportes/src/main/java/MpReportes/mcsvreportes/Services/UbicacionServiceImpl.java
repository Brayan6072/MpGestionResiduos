package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.DTO.ContenedoresDTO;
import MpReportes.mcsvreportes.Entities.LocalizacionContenedores;
import MpReportes.mcsvreportes.persistence.LocalizacionContenedoresRepository;
import MpReportes.mcsvreportes.persistence.ContenedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class UbicacionServiceImpl implements UbicacionService{


    private final LocalizacionContenedoresRepository localizacionContenedoresRepository;

    public UbicacionServiceImpl(LocalizacionContenedoresRepository localizacionContenedoresRepository) {
        this.localizacionContenedoresRepository = localizacionContenedoresRepository;
    }


   /* @Override
    public List<String> findClasificacionesByContenedorNombre(String contenedorNombre) {
        return localizacionContenedoresRepository.findClasificacionesByContenedorNombre(contenedorNombre);
    }*/

    @Override
    public List<Object[]> getContenedoresConClasificaciones() {
        return  localizacionContenedoresRepository.getContenedoresConClasificaciones();
    }


}
