package MpReportes.mcsvreportes.DTO;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UsernameDTO {
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El correo debe ser valido")
    String username;

}
