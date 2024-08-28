package mcsvs.login.User;

import java.util.List;
import java.util.Optional;

import mcsvs.login.DTO.ReportesDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    List <User> findAll();
}
