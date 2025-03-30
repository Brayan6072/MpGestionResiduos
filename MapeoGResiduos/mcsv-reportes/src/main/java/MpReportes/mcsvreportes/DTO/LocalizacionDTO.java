package MpReportes.mcsvreportes.DTO;

import MpReportes.mcsvreportes.Entities.Clasificaciones;
import MpReportes.mcsvreportes.Entities.Contenedores;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @NotEmpty
    @NotBlank
    private Long contenedor_id;

    @NotNull
    @NotBlank
    @NotEmpty
    private List<Long> clasificacion_id = new ArrayList<>();
}


