package topic6.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    List<AppUser> findByCity(String city);

    @Query("SELECT u FROM AppUser u WHERE u.fullName LIKE %:namePart%")
    List<AppUser> searchByName(@Param("namePart") String namePart);
}
