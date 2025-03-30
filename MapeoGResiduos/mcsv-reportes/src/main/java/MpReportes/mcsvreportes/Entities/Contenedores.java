package MpReportes.mcsvreportes.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "Contenedores")
@AllArgsConstructor
@NoArgsConstructor
public class Contenedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Valores nulos no se permiten")
    @NotBlank(message = "Valores en blanco no se permiten")
    @NotEmpty(message = "Valores vacios no se permiten")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "longitud")
    private String longitud;
    @Column(name = "latitud")
    private String latitud;

}
