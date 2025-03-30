package mcsvs.login.Auth;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {


    private String username;
    private String lastname;
    private String name;
    private String phone;
    private String password;

}

