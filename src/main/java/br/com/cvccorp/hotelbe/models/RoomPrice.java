package br.com.cvccorp.hotelbe.models;

import java.text.DecimalFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomPrice {

	private int id;
	private Category category;
	private String totalPrice;
	private PriceDetail priceDetail;
	
	public void calculate(double comissao,long days,int adults,int children) {
		DecimalFormat f = new DecimalFormat("#.##");
		double priceAdult = ((priceDetail.getPricePerDayAdult()*days*adults)/comissao);
		double priceChildren = ((priceDetail.getPricePerDayChild()*days*children)/comissao);
		this.totalPrice = f.format(priceAdult + priceChildren);
	}

}
