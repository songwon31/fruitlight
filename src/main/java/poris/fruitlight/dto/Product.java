package poris.fruitlight.dto;

import lombok.Data;

@Data
public class Product {
   //상품 DTO
   private int PRODUCT_NO;         //상품 no(sequence)
   private String PRODUCT_NAME;    //상품 이름
   private int PRODUCT_PRICE;      //상품 가격
   private int PRODUCT_STOCK;      //상품 재고
   private String PRODUCT_OPTION;  //상품 옵션
   private int DISCOUNT_RATE;      //할인율
   private int DISCOUNT_PRICE;     //할인 가격
}