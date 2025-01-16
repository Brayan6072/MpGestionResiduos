package MpReportes.mcsvreportes.Entities;

import jakarta.persistence.*;
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
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "latitud")
    private String latitud;

}
