package com.plelonek91.app.facility.service;

import com.plelonek91.app.facility.entity.Facility;
import com.plelonek91.app.facility.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    @Override
    public Facility getFacilityById(Long id) {
        return facilityRepository.findById(id).get();
    }
}
