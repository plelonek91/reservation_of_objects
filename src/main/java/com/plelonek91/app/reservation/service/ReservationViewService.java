package com.plelonek91.app.reservation.service;

import com.plelonek91.app.reservation.dto.ReservationRequest;
import com.plelonek91.app.reservation.dto.ReservationResponse;

import java.util.List;

public interface ReservationViewService {

    ReservationResponse createReservation(ReservationRequest reservationRequest);

    ReservationResponse updateReservation(Long reservationId, ReservationRequest reservationRequest);

    List<ReservationResponse> getReservationsByTenantName(String tenantName);

    List<ReservationResponse> getReservationsByFacilityId(Long facilityId);

}
