package org.structure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "registrations")
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @Column(name="time_of_appointment")
    private LocalDateTime date;

    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Appointment appointment;
}
