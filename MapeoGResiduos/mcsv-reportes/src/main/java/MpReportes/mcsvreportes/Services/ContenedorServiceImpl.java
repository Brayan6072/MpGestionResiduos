package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.Entities.Contenedores;
import MpReportes.mcsvreportes.Entities.LocalizacionContenedores;
import MpReportes.mcsvreportes.persistence.ContenedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContenedorServiceImpl implements ContenedorService{

    @Autowired
    private ContenedoresRepository contenedoresRepository;

    @Override
    public Contenedores createContainer(Contenedores contenedores) {
        return contenedoresRepository.save(contenedores);
    }

    @Override
    public Long findIdByNombre(String nombreContenedor) {
        return contenedoresRepository.findIdByNombre(nombreContenedor);
    }


}
