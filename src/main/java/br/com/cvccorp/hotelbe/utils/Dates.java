package br.com.cvccorp.hotelbe.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Dates {
	

	public static long calculaDate(LocalDate checkIn, LocalDate checkOut) {
		return ChronoUnit.DAYS.between(checkIn,checkOut)+1;
	}

}
