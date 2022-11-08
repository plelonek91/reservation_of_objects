package com.plelonek91.app.landlord.entity;

import com.plelonek91.app.reservation.entity.Reservation;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Landlord")
@Table(name = "landlord")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Landlord {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
