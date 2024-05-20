package mcsvs.login.Auth;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String phone;

}

