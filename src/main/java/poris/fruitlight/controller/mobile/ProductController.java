package poris.fruitlight.controller.mobile;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.ProductService;

@Slf4j
@RestController
public class ProductController {

	@Resource
	public ProductService productService;
	
	
	@GetMapping(value="/product/getProduct", produces="application/json; charset=UTF-8")
	public Product getProduct(int product_no) {
		Product product = productService.getProduct(product_no);
		return product;
		
	}
}
