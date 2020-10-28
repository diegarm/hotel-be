package br.com.cvccorp.hotelbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cvccorp.hotelbe.models.Hotel;

@FeignClient(name = "hotelService", url = "http://cvcbackendhotel.herokuapp.com/hotels")
public interface HotelService {
	
	   @RequestMapping(method = RequestMethod.GET, value = "/avail/{cityID}",produces = "application/json")
	   Optional<List<Hotel>> findByCitylId(@PathVariable("cityID") int cityID);
	 
	   @RequestMapping(method = RequestMethod.GET, value = "/{hotelID}",produces = "application/json")
	   Optional<List<Hotel>> findByHotelId(@PathVariable("hotelID") int hotelID);
	 
}
