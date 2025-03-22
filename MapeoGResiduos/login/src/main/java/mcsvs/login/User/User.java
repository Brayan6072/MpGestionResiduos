package mcsvs.login.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Valores en blanco no se permiten")
    @Size(min = 5, max = 50, message = "El nombre de usuario debe tener entre 5 y 50 caracteres")
    @Email(message = "Debe ser un email valido")
    @Basic
    @Column(nullable = false)
    String username;

    @NotBlank(message = "Valores en blanco no se permiten")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Solo se aceptan letras y espacios")
    @Column(nullable = false)
    String lastname;

    @NotBlank(message = "Valores en blanco no se permiten")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Solo se aceptan letras y espacios")
    String name;

    @NotBlank(message = "Valores en blanco no se permiten")
    @Size(min = 10, max = 15, message = "El teléfono debe tener entre 10 y 15 dígitos")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "El teléfono debe ser un número válido (formato internacional opcional)")
    String phone;

    @NotBlank(message = "Valores en blanco no se permiten")
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La contraseña debe contener al menos una letra mayúscula, una minúscula, un número y un carácter especial")
    @Column(nullable = false)
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
