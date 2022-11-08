package com.plelonek91.app.reservation.service;

import com.plelonek91.app.facility.entity.Facility;
import com.plelonek91.app.facility.service.FacilityService;
import com.plelonek91.app.landlord.entity.Landlord;
import com.plelonek91.app.landlord.service.LandlordService;
import com.plelonek91.app.reservation.dto.ReservationRequest;
import com.plelonek91.app.reservation.dto.ReservationResponse;
import com.plelonek91.app.reservation.entity.Reservation;
import com.plelonek91.app.tenant.entity.Tenant;
import com.plelonek91.app.tenant.service.TenantService;
import com.plelonek91.app.util.Utils;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Data
public class ReservationMapper {

    private final FacilityService facilityService;
    private final LandlordService landlordService;
    private final TenantService tenantService;

    public ReservationResponse createReservationResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .landlord(reservation.getLandlord())
                .tenant(reservation.getTenant())
                .facility(reservation.getFacility())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .duration(Utils.getDuration(reservation.getStartDate(), reservation.getEndDate()))
                .totalPrice(reservation.getPrice())
                .build();
    }

    public Reservation updateReservation(ReservationRequest reservationRequest, Reservation reservation) {

        //TODO klasa generyczna by się przydała...

        Facility updatedFacility = getUpdatedFacility(reservationRequest.getFacilityId(), reservation);
        Landlord updatedLandlord = getUpdatedLandlord(updatedFacility, reservation);
        Tenant updatedTenant = getUpdatedTenant(reservationRequest.getTenantId(), reservation);
        LocalDate updatedStartDate = getUpdatedStartDate(reservationRequest.getStartDate(), reservation);
        LocalDate updatedEndDate = getUpdatedEndDate(reservationRequest.getEndDate(), reservation);
        Float updatedPrice = getUpdatedPrice(updatedFacility, Utils.getDuration(updatedStartDate, updatedEndDate));

        return Reservation.builder()
                .id(reservation.getId())
                .facility(updatedFacility)
                .landlord(updatedLandlord)
                .tenant(updatedTenant)
                .startDate(updatedStartDate)
                .endDate(updatedEndDate)
                .price(updatedPrice)
                .build();
    }

    private Float getUpdatedPrice(Facility updatedFacility, Long updatedDuration) {
        return updatedFacility.getPrice() * updatedDuration;
    }

    private LocalDate getUpdatedEndDate(LocalDate requestEndDate, Reservation reservation) {
        if(!reservation.getEndDate().equals(requestEndDate) && requestEndDate != null) {
            return requestEndDate;
        }
        return reservation.getEndDate();
    }

    private LocalDate getUpdatedStartDate(LocalDate requestStartDate, Reservation reservation) {
        if(!reservation.getStartDate().equals(requestStartDate) && requestStartDate != null) {
            return requestStartDate;
        }
        return reservation.getStartDate();
    }

    private Tenant getUpdatedTenant(Long requestTenantId, Reservation reservation) {

        if (!reservation.getTenant().getId().equals(requestTenantId) && requestTenantId != null) {
            return tenantService.getTenantById(requestTenantId);
        }
        return reservation.getTenant();
    }

    private Landlord getUpdatedLandlord(Facility updatedFacility, Reservation reservation) {

        if (!reservation.getLandlord().getId().equals(updatedFacility.getLandlord().getId()))
            return landlordService.getLandlordById(updatedFacility.getLandlord().getId());
        return reservation.getLandlord();
    }

    private Facility getUpdatedFacility(Long requestFacilityId, Reservation reservation) {

        if (!reservation.getFacility().getId().equals(requestFacilityId) && requestFacilityId != null) {
            return facilityService.getFacilityById(requestFacilityId);
        }
        return reservation.getFacility();
    }
}
