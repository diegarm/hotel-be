package br.com.cvccorp.hotelbe.models;

import java.util.List;

import lombok.Data;

@Data
public class Hotel {
	
	private int id;
	private String name;
	private int cityCode;
	private String cityName;
	private List<Room> rooms;	

}
