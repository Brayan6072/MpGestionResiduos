package MpReportes.mcsvreportes.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ContenedoresDTO {
    private String nombreContenedor;
    private String latitud;
    private String longitud;
    private String clasificaciones;


    public ContenedoresDTO(String nombreContenedor, String latitud, String longitud, String clasificaciones) {
        this.nombreContenedor = nombreContenedor;
        this.latitud = latitud;
        this.longitud = longitud;
        this.clasificaciones = clasificaciones;
    }


    public String getNombreContenedor() { return nombreContenedor; }
    public String getLatitud() { return latitud; }
    public String getLongitud() { return longitud; }
    public String getClasificacion() { return clasificaciones; }
}
