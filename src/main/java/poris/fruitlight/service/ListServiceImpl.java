package poris.fruitlight.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dto.ProductList;

@Service
@Slf4j
public class ListServiceImpl implements ListService{
	
	@Resource
	private ProductDao productDao;

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
