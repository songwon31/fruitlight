package poris.fruitlight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.MyPageShopperInquiryDao;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.ProductInquiry;

/**
 * 
 * @author 이은지
 *
 */
@Slf4j
@Service
public class MyPageShopperInquiryServiceImpl implements MyPageShopperInquiryService {
	@Autowired
	MyPageShopperInquiryDao myPageShopperInquiryDao;

	@Override
	public List<String> getMShopperInquiryProductList(int sno) {
		List<String> list = myPageShopperInquiryDao.selectShopperInquiryProductList(sno);
		return list;
	}
	
	@Override
	public List<ProductInquiry> getMShopperInquiryList(ProductInquiry productInquiry) {
		List<ProductInquiry> list = myPageShopperInquiryDao.selectShopperInquiry(productInquiry);
		return list;
	}
	
	//회원별 상품문의 목록 가져오기
	@Override
	public List<ProductInquiry> getShopperInquiryList(Pager pager, int sno) {
		pager.setShopperNo(sno);
		List<ProductInquiry> list = myPageShopperInquiryDao.selectShopperInquiryPager(pager);
		return list;
	}

	//회원별 총 상품문의 수 가져오기
	@Override
	public int getTotalShopperInquiryNum(int sno) {
		int totalProductInquiryNum = myPageShopperInquiryDao.countShopperInquiry(sno);
		return totalProductInquiryNum;
	}

	//상품문의 글 삭제
	@Override
	public void deleteShopperInquiry(int ino) {
		myPageShopperInquiryDao.deleteShopperInquiry(ino);
	}
	
	//회원별 쿠폰 목록 가져오기
	@Override
	public List<Coupon> getCoupon(int sno) {
		List<Coupon> list = myPageShopperInquiryDao.selectCouponBySno(sno);
		return list;
	}
}
