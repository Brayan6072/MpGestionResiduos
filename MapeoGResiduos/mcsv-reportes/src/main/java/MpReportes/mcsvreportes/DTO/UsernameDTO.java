package MpReportes.mcsvreportes.DTO;


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

    String username;


}
