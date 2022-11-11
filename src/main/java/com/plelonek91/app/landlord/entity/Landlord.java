package com.plelonek91.app.landlord.entity;

import com.plelonek91.app.facility.entity.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<Facility> facilities;
}
