package MpReportes.mcsvreportes.persistence;

import MpReportes.mcsvreportes.Entities.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ReporteRepository extends JpaRepository<Reportes, Long> {

//    @Query("SELECT s FROM Reportes s WHERE s.reporteId = :idReportes")
//    List<Reportes> findAllReportes(Long idReportes);


}
