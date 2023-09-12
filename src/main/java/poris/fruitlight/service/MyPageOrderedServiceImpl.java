package poris.fruitlight.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.OrderHistoryDao;
import poris.fruitlight.dto.OrderHistoryOrderList;
import poris.fruitlight.dto.OrderSearchParam;
import poris.fruitlight.dto.Pager;

@Service
@Slf4j
public class MyPageOrderedServiceImpl implements MyPageOrderedService{
   
@Resource
private OrderHistoryDao orderHistoryDao;
   
	@Override
	public List<OrderHistoryOrderList> getList(Pager pager,int sid) {
		pager.setShopperNo(sid);
		List<OrderHistoryOrderList> list = orderHistoryDao.SelectOrderHistory(pager);
		      
		return list;
	}

	@Override
	public List<OrderHistoryOrderList> searchOrderList(OrderSearchParam orderSearch) {
		List<OrderHistoryOrderList> dbResult = orderHistoryDao.SearchOrdersByPname(orderSearch);
		
		return dbResult;
	}

	@Override
	public int SelectTotalOrderHistory(int shopperNo) {
		return orderHistoryDao.SelectTotalOrderHistory(shopperNo);
	}
   

}
