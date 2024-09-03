package tech.xoslu.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String code;
    private String programId;
    private String photo;
}
