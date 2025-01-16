package MpReportes.mcsvreportes.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "localizacion_contenedores")
@AllArgsConstructor
@NoArgsConstructor

public class LocalizacionContenedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contenedor_id", nullable = false)
    private Contenedores contenedores;

    @ManyToOne
    @JoinColumn(name = "clasificacion_id", nullable = false)
    private Clasificaciones clasificaciones;
}
