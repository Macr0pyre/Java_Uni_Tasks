package org.structure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;
    private String email;
    private String login;
    private String password;
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Registration> registrations;
}
