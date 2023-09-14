package poris.fruitlight.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MorderHistory {

	private Date order_date;
	private String product_name;
	private String product_option;
	private int price;
	private int stock;
	private int payment_price;
	
}
