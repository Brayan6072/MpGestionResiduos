package mcsvs.login.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportesDTO {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private String estatus;
    private String etiquetau;
    private String clasificacion;
}
