package com.plelonek91.app.facility.repository;

import com.plelonek91.app.facility.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Deprecated
public interface FacilityRepository extends JpaRepository<Facility, Long> {

}
