package poris.fruitlight.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dto.MobileBoardMedia;
import poris.fruitlight.dto.MobileProductForList;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.ProductList;

@Service
@Slf4j
public class ListServiceImpl implements ListService{
	
	@Resource
	private ProductDao productDao;
	
	@Override
	public List<MobileProductForList> getCherryAdList() {
		List<MobileProductForList> list = new ArrayList<>();
		List<Product> productList = productDao.selectCherryAdList();
		
		for (Product product : productList) {
			List<Integer> productStarRateList = productDao.selectStarRateList(product.getPRODUCT_NO());
			double star_rate = 0.0;
			int rate_count = 0;
			rate_count = productStarRateList.size();
			if (rate_count > 0) {
				star_rate = productStarRateList
						.stream()
						.mapToInt(num -> num)
						.summaryStatistics()
						.getAverage();
			}
			MobileProductForList mobileProductForList = new MobileProductForList();
			mobileProductForList.setProduct_no(product.getPRODUCT_NO());
			mobileProductForList.setProduct_name(product.getPRODUCT_NAME());
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			String product_price = "" + df.format(product.getPRODUCT_PRICE()) + "원";
			mobileProductForList.setProduct_price(product_price);
			String discount_rate = "" + df.format(product.getDISCOUNT_RATE()) + "%";
			mobileProductForList.setDiscount_rate(discount_rate);
			String discount_price = "" + df.format(product.getDISCOUNT_PRICE()) + "원";
			mobileProductForList.setDiscount_price(discount_price);
			//100점 만점 -> 5점 만점으로 환산
			star_rate = (star_rate * 5.0) / 100.0;
			//소수점 첫째 자리까지 반올림
			mobileProductForList.setStar_rate(Math.round(star_rate*10)/10.0);
			mobileProductForList.setRate_count(rate_count);
			list.add(mobileProductForList);
		}
		
		return list;
	}
	
	@Override
	public List<MobileProductForList> getWatermelonAdList() {
		List<MobileProductForList> list = new ArrayList<>();
		List<Product> productList = productDao.selectWatermelonAdList();
		
		for (Product product : productList) {
			List<Integer> productStarRateList = productDao.selectStarRateList(product.getPRODUCT_NO());
			double star_rate = 0.0;
			int rate_count = 0;
			rate_count = productStarRateList.size();
			if (rate_count > 0) {
				star_rate = productStarRateList
						.stream()
						.mapToInt(num -> num)
						.summaryStatistics()
						.getAverage();
			}
			MobileProductForList mobileProductForList = new MobileProductForList();
			mobileProductForList.setProduct_no(product.getPRODUCT_NO());
			mobileProductForList.setProduct_name(product.getPRODUCT_NAME());
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			String product_price = "" + df.format(product.getPRODUCT_PRICE()) + "원";
			mobileProductForList.setProduct_price(product_price);
			String discount_rate = "" + df.format(product.getDISCOUNT_RATE()) + "%";
			mobileProductForList.setDiscount_rate(discount_rate);
			String discount_price = "" + df.format(product.getDISCOUNT_PRICE()) + "원";
			mobileProductForList.setDiscount_price(discount_price);
			//100점 만점 -> 5점 만점으로 환산
			star_rate = (star_rate * 5.0) / 100.0;
			//소수점 첫째 자리까지 반올림
			mobileProductForList.setStar_rate(Math.round(star_rate*10)/10.0);
			mobileProductForList.setRate_count(rate_count);
			list.add(mobileProductForList);
		}
		
		return list;
	}
	
	@Override
	public List<MobileProductForList> getMangoAdList() {
		List<MobileProductForList> list = new ArrayList<>();
		List<Product> productList = productDao.selectMangoAdList();
		
		for (Product product : productList) {
			List<Integer> productStarRateList = productDao.selectStarRateList(product.getPRODUCT_NO());
			double star_rate = 0.0;
			int rate_count = 0;
			rate_count = productStarRateList.size();
			if (rate_count > 0) {
				star_rate = productStarRateList
						.stream()
						.mapToInt(num -> num)
						.summaryStatistics()
						.getAverage();
			}
			MobileProductForList mobileProductForList = new MobileProductForList();
			mobileProductForList.setProduct_no(product.getPRODUCT_NO());
			mobileProductForList.setProduct_name(product.getPRODUCT_NAME());
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			String product_price = "" + df.format(product.getPRODUCT_PRICE()) + "원";
			mobileProductForList.setProduct_price(product_price);
			String discount_rate = "" + df.format(product.getDISCOUNT_RATE()) + "%";
			mobileProductForList.setDiscount_rate(discount_rate);
			String discount_price = "" + df.format(product.getDISCOUNT_PRICE()) + "원";
			mobileProductForList.setDiscount_price(discount_price);
			//100점 만점 -> 5점 만점으로 환산
			star_rate = (star_rate * 5.0) / 100.0;
			//소수점 첫째 자리까지 반올림
			mobileProductForList.setStar_rate(Math.round(star_rate*10)/10.0);
			mobileProductForList.setRate_count(rate_count);
			list.add(mobileProductForList);
		}
		
		return list;
	}
	
	@Override
	public List<MobileProductForList> getMobileProductsForList() {
		List<MobileProductForList> list = new ArrayList<>();
		List<Product> productList = productDao.selectProductList();
		
		for (Product product : productList) {
			List<Integer> productStarRateList = productDao.selectStarRateList(product.getPRODUCT_NO());
			double star_rate = 0.0;
			int rate_count = 0;
			rate_count = productStarRateList.size();
			if (rate_count > 0) {
				star_rate = productStarRateList
						.stream()
						.mapToInt(num -> num)
						.summaryStatistics()
						.getAverage();
			}
			MobileProductForList mobileProductForList = new MobileProductForList();
			mobileProductForList.setProduct_no(product.getPRODUCT_NO());
			mobileProductForList.setProduct_name(product.getPRODUCT_NAME());
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			String product_price = "" + df.format(product.getPRODUCT_PRICE()) + "원";
			mobileProductForList.setProduct_price(product_price);
			String discount_rate = "" + df.format(product.getDISCOUNT_RATE()) + "%";
			mobileProductForList.setDiscount_rate(discount_rate);
			String discount_price = "" + df.format(product.getDISCOUNT_PRICE()) + "원";
			mobileProductForList.setDiscount_price(discount_price);
			//100점 만점 -> 5점 만점으로 환산
			star_rate = (star_rate * 5.0) / 100.0;
			//소수점 첫째 자리까지 반올림
			mobileProductForList.setStar_rate(Math.round(star_rate*10)/10.0);
			mobileProductForList.setRate_count(rate_count);
			list.add(mobileProductForList);
		}
		
		return list;
	}
	
	/**
	 * 썸네일 가져오기
	 */
	@Override
	public MobileBoardMedia getThumbnailImage(int board_no) {
		return productDao.selectThumbnailImage(board_no);
	}

	/**
	 * 이름으로 검색된 내용만 가져오기
	 */
	@Override
	public List<ProductList> SearchProductsByPname(String pname) {
		 return productDao.SearchProductsByPname(pname);
	}

	/**
	 * 전체 상품 가져오기
	 */
	@Override
	public List<ProductList> SearchProducts() {
		return productDao.SearchProducts();
	}
	
	/**
	 * 상품 고유 번호를 통해 그에 맞는 상품 상세 정보 페이지 가져오기
	 */
	@Override
	public int getSelectBoardNo(int pid) {
		int dbResult = productDao.SelectDetailView(pid);
		
		return dbResult;
	}
}
