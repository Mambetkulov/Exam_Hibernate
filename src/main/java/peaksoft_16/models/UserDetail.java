package peaksoft_16.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userD_id")
    @SequenceGenerator(name = "userD_id",sequenceName = "userdSq",allocationSize = 1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String address;

     public UserDetail(String fullName, String address){
        this.fullName = fullName;
        this.address = address;
    }

    @PrePersist @PreUpdate
    public void prePersist() {
        dateOfBirth = LocalDate.now();
    }




}
