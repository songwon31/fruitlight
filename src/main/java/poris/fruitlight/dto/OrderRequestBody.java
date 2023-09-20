package poris.fruitlight.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequestBody {
	private OrderHistory order;
    private List<Coupon> couponList;
    private List<ReceiptHistory> receiptHistoryList;
    private List<Cart> cartList;

    public OrderRequestBody(OrderHistory order, List<Coupon> couponList, List<ReceiptHistory> receiptHistoryList, List<Cart> cartList) {
        this.order = order;
        this.couponList = couponList;
        this.receiptHistoryList = receiptHistoryList;
        this.cartList = cartList;
    }

}
