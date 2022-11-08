package com.plelonek91.app.reservation.entity;

import com.plelonek91.app.facility.entity.Facility;
import com.plelonek91.app.landlord.entity.Landlord;
import com.plelonek91.app.tenant.entity.Tenant;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Reservation")
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @OneToOne
    private Facility facility;

    @OneToOne
    private Landlord landlord;

    @OneToOne
    private Tenant tenant;

    private LocalDate startDate;

    private LocalDate endDate;

    private Float price;

}
