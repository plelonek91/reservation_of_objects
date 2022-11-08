package com.plelonek91.app.reservation.service;

import com.plelonek91.app.reservation.entity.Reservation;

import java.util.List;


public interface ReservationService {

    Reservation save(Reservation reservation);

    Reservation update(Reservation reservation);

    List<Reservation> getByTenantName(String name);

    List<Reservation> getByFacilityName(String name);

    Reservation getById(Long id);
}
