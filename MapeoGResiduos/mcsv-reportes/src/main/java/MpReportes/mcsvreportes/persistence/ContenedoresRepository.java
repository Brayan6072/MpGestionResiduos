package MpReportes.mcsvreportes.persistence;

import MpReportes.mcsvreportes.DTO.ContenedoresDTO;
import MpReportes.mcsvreportes.Entities.Contenedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContenedoresRepository extends JpaRepository<Contenedores, Long> {


}
