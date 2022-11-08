package com.plelonek91.app.tenant.entity;

import com.plelonek91.app.reservation.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Tenant")
@Table(name = "tenant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
