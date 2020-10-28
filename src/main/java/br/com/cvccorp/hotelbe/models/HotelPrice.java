package br.com.cvccorp.hotelbe.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelPrice {
	private int id;
	private String city;
	private List<RoomPrice> rooms;
}
