package topic6.app.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(name = "uk_app_user_email", columnNames = "email")
})
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = true)
    private String email;

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void prePersist() {
        createdAt = Instant.now();
    }
    public AppUser() {
    }
    public AppUser(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }



}
