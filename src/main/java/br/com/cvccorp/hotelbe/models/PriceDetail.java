package br.com.cvccorp.hotelbe.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDetail {

	private double pricePerDayAdult = 0;
	private double pricePerDayChild= 0;	
	

}
