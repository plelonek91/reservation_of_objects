package com.plelonek91.app.landlord.repository;

import com.plelonek91.app.landlord.entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {
}
