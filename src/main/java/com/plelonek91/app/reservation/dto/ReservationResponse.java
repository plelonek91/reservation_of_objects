package com.plelonek91.app.reservation.dto;

import com.plelonek91.app.facility.entity.Facility;
import com.plelonek91.app.landlord.entity.Landlord;
import com.plelonek91.app.tenant.entity.Tenant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Builder
@Data
public class ReservationResponse {

    private Long id;

    private Landlord landlord;

    private Tenant tenant;

    private Facility facility;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long duration;

    private Float totalPrice;

}
