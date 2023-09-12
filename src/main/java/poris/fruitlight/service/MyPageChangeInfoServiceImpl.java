package poris.fruitlight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.ShopperDao;
import poris.fruitlight.dto.Shopper;

@Service
@Slf4j
public class MyPageChangeInfoServiceImpl implements MyPageChangeInfoService{
	
	@Autowired
	ShopperDao shopperDao;
	
	@Override
	public Shopper getShopper(int shopperNo) {
		Shopper shopperinfo = shopperDao.selectShopperBySid(shopperNo);
		return shopperinfo;
	}

	@Override
	public void modify(Shopper shopper) {
		shopperDao.updateShopper(shopper);
	}
	
	@Override
	public boolean shopperIdDuplicateCheck(Shopper shopper) {
		// Step1. 중복 ID 조회
		String resultId = shopperDao.selectShopperId(shopper.getShopperId());
		
		if(resultId == null) {
			// Step2. 중복 ID 없으면 업데이트
			shopperDao.updateShopper(shopper);
			return false;
		} else return true;
	}
	
	/**
	 * 유저가 입력한 데이터가 DB의 PW와 동일한지 확인 요청하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param shopper - 회원 정보
	 * @return boolean
	 */
	@Override
	public boolean isShopperPw(Shopper shopper) {
		// Step1. DB에서 ID를 기준으로 일치하는 유저 정보 조회
		Shopper dbShopper = shopperDao.selectShopper(shopper);
		// Step2. 일치하는 유저 정보가 있는지 확인
		if(dbShopper != null) {
			// Step3. 입력한 PW와  DB의 패스워드가 같은지 확인
			if(dbShopper.getShopperPw().equals(shopper.getShopperPw())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public void setShopperTel(Shopper shopper) {
		shopperDao.updateShopperTel(shopper);
	}
	
	@Override
	public void setShopperPassword(Shopper shopper) {
		shopperDao.updateShopperPW(shopper);
	}

}
