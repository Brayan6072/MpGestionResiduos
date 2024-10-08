package MpReportes.mcsvreportes.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Builder
@Table(name = "reportes")
@AllArgsConstructor
@NoArgsConstructor


public class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estatus")
    private String estatus = "Rojo";

    @Column(name = "etiquetau")
    private String etiquetau;

    @Column(name = "clasificacion")
    private String clasificacion;

    public String getEstatus() {
        return estatus;
    }

    public String getEtiquetau() {
        return etiquetau;
    }

    public String getEstado() {
        return estado;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}
