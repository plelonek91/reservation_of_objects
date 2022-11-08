package com.plelonek91.app.reservation.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationRequest {

    private Long tenantId;

    private Long facilityId;

    private LocalDate startDate;

    private LocalDate endDate;

}
