package com.plelonek91.app.reservation.controller;

import com.plelonek91.app.reservation.dto.ReservationRequest;
import com.plelonek91.app.reservation.dto.ReservationResponse;
import com.plelonek91.app.reservation.service.ReservationViewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation/")
@AllArgsConstructor
public class ReservationController {

    ReservationViewService reservationViewService;


    @PostMapping("new")
    ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {
        return ResponseEntity.ok(reservationViewService.createReservation(reservationRequest));
    }

    @PatchMapping("updateById/{reservationId}")
    ResponseEntity<ReservationResponse> updateReservation(@PathVariable Long reservationId, @RequestBody ReservationRequest reservationRequest) {
        return ResponseEntity.ok(reservationViewService.updateReservation(reservationId, reservationRequest));
    }

    @GetMapping("getByTenantName/{tenantName}")
    ResponseEntity<List<ReservationResponse>> getReservationsByTenantName(@PathVariable String tenantName) {
        return ResponseEntity.ok(reservationViewService.getReservationsByTenantName(tenantName));
    }

    @GetMapping("getByFacilityId/{facilityId}")
    ResponseEntity<List<ReservationResponse>> getReservationsByFacilityId(@PathVariable Long facilityId) {
        return ResponseEntity.ok(reservationViewService.getReservationsByFacilityId(facilityId));
    }

}
