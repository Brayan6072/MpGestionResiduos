package MpReportes.mcsvreportes.DTO;

import MpReportes.mcsvreportes.Entities.Clasificaciones;
import MpReportes.mcsvreportes.Entities.Contenedores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacionDTO {

    private Long id;
    private Long contenedor_id;
    private List<Long> clasificacion_id = new ArrayList<>();
}


