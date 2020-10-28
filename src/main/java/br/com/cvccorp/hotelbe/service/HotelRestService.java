package br.com.cvccorp.hotelbe.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cvccorp.hotelbe.expections.ValidationException;
import br.com.cvccorp.hotelbe.models.Category;
import br.com.cvccorp.hotelbe.models.Hotel;
import br.com.cvccorp.hotelbe.models.HotelPrice;
import br.com.cvccorp.hotelbe.models.PriceDetail;
import br.com.cvccorp.hotelbe.models.Room;
import br.com.cvccorp.hotelbe.models.RoomPrice;
import br.com.cvccorp.hotelbe.utils.Dates;

@Service
@CacheConfig(cacheNames={"hotel"})
public class HotelRestService {
	
	private final HotelService hotelService;
	 
	
   public HotelRestService(HotelService hotelService) {
        this.hotelService = hotelService;
    }
	 
   @Cacheable(value = "hotel")
	 public List<Hotel> findByHotelId(int hotelID) throws ValidationException {
		 Optional<List<Hotel>> optionalHotel = hotelService.findByHotelId(hotelID);
		 
		 if(!optionalHotel.isPresent())
			 throw new ValidationException("001","Hotel não localizado");
		 
		 return optionalHotel.get();
	 }
	 
	 @Cacheable(value = "hotelCity")
	 public List<Hotel> findByCityID(int cityID) throws ValidationException {
		 Optional<List<Hotel>> optionalHotel = hotelService.findByCitylId(cityID);
		 
		 if(!optionalHotel.isPresent())
			 throw new ValidationException("001","Hotel não localizado");
		 
		 return optionalHotel.get();
	 }
   
   
	 @ResponseStatus(HttpStatus.OK)
	 public List<HotelPrice> getPriceByHotel(int cityID, int hotelID, LocalDate checkIn, LocalDate checkOut, int adults, int children) throws ValidationException {

		 long days =  Dates.calculaDate(checkIn, checkOut);
		 List<Hotel> hotels = (hotelID == -1 ? findByCityID(cityID) : findByHotelId(hotelID));
		 
		 List<HotelPrice> hotelsPrice = new ArrayList<HotelPrice>();
		 
		 for(Hotel hotel: hotels) {
			 List<RoomPrice> roomsPrice = new ArrayList<RoomPrice>();
			 
			 for(Room room: hotel.getRooms()) {
				 
				 RoomPrice roomPrice = RoomPrice.builder()
				 	.id(room.getRoomID())
				 	.category(Category.builder().name(room.getCategoryName()).build())
				 	.priceDetail(PriceDetail.builder()
				 			.pricePerDayAdult(room.getPrice().getAdult())
				 			.pricePerDayChild(room.getPrice().getChild())
				 			.build())
				 	.build();
				 roomPrice.calculate(0.7,days,adults,children);
				 roomsPrice.add(roomPrice);					 	
				 		
			 }
			 
			 hotelsPrice.add(HotelPrice.builder()
					 .id(hotel.getId())
					 .city(hotel.getCityName())
					 .rooms(roomsPrice)
					 .build()
		 				);
		 }		 
		 
		 
		 return hotelsPrice;
		 
	 }

	public List<HotelPrice> getPriceByHotel(int cityID, LocalDate checkIn, LocalDate checkOut, int adults,
			int children) throws ValidationException {
		return getPriceByHotel(cityID,-1,checkIn,checkOut,adults,children);
	}


}
