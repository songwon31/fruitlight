package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.MorderHistory;
import poris.fruitlight.dto.OrderHistoryOrderList;
import poris.fruitlight.dto.OrderSearchParam;
import poris.fruitlight.dto.Pager;

public interface MyPageOrderedService {
	/**
	 * @author 김진성
	 * @param pager - 페이징 처리를 위한 Pager DTO
	 * @param sid - 사용자 고유 번호
	 * @return 사용자가 주문했던 목록
	 */
    public List<OrderHistoryOrderList> getList(Pager pager,int sid);
    public List<MorderHistory> getOrderHistory(int shopperNo);
    
    /**
     * @author 김진성
     * @param orderSearch - 그 사용자가 주문했던 목록중 검색한 내용을 가져오는 DTO
     * @return 검색한 주문 목록
     */
    public List<OrderHistoryOrderList> searchOrderList(OrderSearchParam orderSearch);
    
    /**
     * @author 김진성
     * @param shopperNo - 사용자 고유 번호
     * @return 사용자가 주문한 총 목록의 수
     */
    public int SelectTotalOrderHistory(int shopperNo);
}