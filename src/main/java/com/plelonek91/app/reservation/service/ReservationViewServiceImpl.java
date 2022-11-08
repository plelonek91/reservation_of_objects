package com.plelonek91.app.reservation.service;

import com.plelonek91.app.facility.service.FacilityService;
import com.plelonek91.app.reservation.dto.ReservationRequest;
import com.plelonek91.app.reservation.dto.ReservationResponse;
import com.plelonek91.app.reservation.entity.Reservation;
import com.plelonek91.app.tenant.service.TenantService;
import com.plelonek91.app.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationViewServiceImpl implements ReservationViewService {

    private final ReservationService reservationService;
    private final FacilityService facilityService;
    private final TenantService tenantService;
    private final ReservationMapper reservationMapper;


    @Override
    @Transactional
    public ReservationResponse createReservation(ReservationRequest reservationRequest) {

        Reservation reservation = buildReservationEntity(reservationRequest);

        reservationService.save(reservation);

        return reservationMapper.createReservationResponse(reservation);

    }

    @Override
    public ReservationResponse updateReservation(Long reservationId, ReservationRequest reservationRequest) {

        Reservation reservation = reservationService.getById(reservationId);
        Reservation updatedReservation = reservationMapper.updateReservation(reservationRequest, reservation);
        return null;//TODO jakiś zapis na bazę i pewnie response
    }

    @Override
    public List<ReservationResponse> getReservationsByTenantName(String tenantName) {
        return null;//TODO
    }

    @Override
    public List<ReservationResponse> getReservationsByFacilityId(Long facilityId) {
        return null;//TODO
    }

    private Reservation buildReservationEntity(ReservationRequest reservationRequest) {
        Long facilityId = reservationRequest.getFacilityId();
        Long tenantId = reservationRequest.getTenantId();

        Long duration = Utils.getDuration(reservationRequest.getStartDate(),
                reservationRequest.getEndDate());
        float unitPrice = facilityService.getFacilityById(facilityId).getPrice();

        return Reservation.builder()
                .facility(facilityService.getFacilityById(facilityId))
                .landlord(facilityService.getFacilityById(facilityId).getLandlord())
                .tenant(tenantService.getTenantById(tenantId))
                .startDate(reservationRequest.getStartDate())
                .endDate(reservationRequest.getEndDate())
                .price(getReservationPrice(unitPrice, duration))
                .build();
    }

    private Float getReservationPrice(Float unitPrice, Long duration) {
        return unitPrice * duration.floatValue();
    }

}
