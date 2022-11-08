package com.plelonek91.app.reservation.service;

import com.plelonek91.app.reservation.entity.Reservation;
import com.plelonek91.app.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;


    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getByTenantName(String name) {
        return null;
    }

    @Override
    public List<Reservation> getByFacilityName(String name) {
        return null;
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).get();
    }
}
