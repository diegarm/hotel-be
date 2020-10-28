package br.com.cvccorp.hotelbe.models;

import java.util.List;

import lombok.Data;

@Data
public class Room {

	private int roomID;
	private String categoryName;
	private Price price;
	
}
