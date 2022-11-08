package com.plelonek91.app.util;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Utils {

    public static Long getDuration(LocalDate startDate, LocalDate endDate) {
        return DAYS.between(startDate, endDate);
    }
}
