package com.plelonek91.app.landlord.service;

import com.plelonek91.app.landlord.entity.Landlord;
import com.plelonek91.app.landlord.repository.LandlordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LandlordServiceImpl implements LandlordService{

    LandlordRepository landlordRepository;

    @Override
    public Landlord getLandlordById(Long id) {
        return landlordRepository.findById(id).get();
    }
}
