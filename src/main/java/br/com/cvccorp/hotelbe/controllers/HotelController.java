package br.com.cvccorp.hotelbe.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvccorp.hotelbe.models.HotelPrice;
import br.com.cvccorp.hotelbe.service.HotelRestService;

@RestController
@CrossOrigin
public class HotelController {

    @Autowired
    private HotelRestService hotelService;
	
	@RequestMapping(method= RequestMethod.GET, value="/citys/{cityID}/hotels/{hotelID}/checkIn/{checkIn}/checkOut/{checkOut}/adults/{adults}/children/{children}")
	public List<HotelPrice> getPriceHotel(
			@PathVariable("cityID") int cityID,
			@PathVariable("hotelID") int hotelID,
			@PathVariable("checkIn") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate checkIn,
			@PathVariable("checkOut") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate checkOut,
			@PathVariable("adults") int adults,
			@PathVariable("children") int children			
			) throws Exception {
		return hotelService.getPriceByHotel(cityID,hotelID,checkIn,checkOut,adults,children);
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/citys/{cityID}/hotels/checkIn/{checkIn}/checkOut/{checkOut}/adults/{adults}/children/{children}")
	public List<HotelPrice> getPriceAllHotel(
			@PathVariable("cityID") int cityID,
			@PathVariable("checkIn") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate checkIn,
			@PathVariable("checkOut") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate checkOut,
			@PathVariable("adults") int adults,
			@PathVariable("children") int children			
			) throws Exception {
		return hotelService.getPriceByHotel(cityID,checkIn,checkOut,adults,children);
	}

}
