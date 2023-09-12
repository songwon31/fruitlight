package poris.fruitlight.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dto.ProductList;

@Service
@Slf4j
public class MainServiceImpl implements MainService{
   
   @Resource
   private ProductDao productDao;

   @Override
   public List<ProductList> getMainList() {
      List<ProductList> list = productDao.MainBanner();
      
      return list;
   }

   @Override
   public List<ProductList> getTodayList() {
      List<ProductList> list = productDao.TodayDiscovery();
      
      return list;
   }

   @Override
   public List<ProductList> getSellerList() {
      List<ProductList> list = productDao.TodaySeller();
      
      return list;
   }

   @Override
   public List<ProductList> getCateMainList() {
	   List<ProductList> list = productDao.CategoryMain();
	      
	   return list;
   }

   @Override
   public List<ProductList> getCateSubList() {
      List<ProductList> list = productDao.CategorySub();
      
      return list;
   }

	
	/**
	 * 상품 고유번호를 기준으로 게시판의 번호를 조회하는 메소드
	 * @author 고재승
	 * @param pid - 제품(상품) 고유번호
	 */
	@Override
	public int getSelectBoardNo(int pid) {
		
		int dbResult = productDao.SelectDetailView(pid);
		
		return dbResult;
	}


	@Override
	public List<ProductList> SelectListName(String pname) {
		List<ProductList> dbResult = productDao.SearchProductsByPname(pname);
		
		return dbResult;
	}
}