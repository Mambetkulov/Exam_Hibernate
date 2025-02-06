package peaksoft_16.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userP_id")
    @SequenceGenerator(name = "userP_id",sequenceName = "userpSq",allocationSize = 1)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "registration_date ",nullable = false)
    private LocalDate registrationDate;


    @OneToOne(cascade = CascadeType.ALL)
    private UserDetail userDetail;


    public UserProfile(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @PrePersist @PreUpdate
    public void prePersist() {
        registrationDate = LocalDate.now();
    }
}
