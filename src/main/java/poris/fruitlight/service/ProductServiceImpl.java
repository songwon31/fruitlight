package poris.fruitlight.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dto.Product;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	@Resource
	private ProductDao productDao;
	
	@Override
	public Product getProduct(int product_no) {
		return productDao.selectProductById(product_no);
	}
	
	

}
