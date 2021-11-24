package ru.andreeva.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @Column(name = "registration_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "registration_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Registration registration;

    private String description;

    private Status status;

    @Column(name= "is_visited")
    private Boolean isVisited;
}
