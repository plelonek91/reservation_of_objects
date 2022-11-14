package com.plelonek91.app.facility.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.plelonek91.app.landlord.entity.Landlord;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Facility")
@Table(name = "facility")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String name;

    private Float price;

    private Float area;

    private String description;

    @OneToOne
    @JsonBackReference
    private Landlord landlord;

}
