package poris.fruitlight.dto;

import lombok.Data;

/**
 * 주문 내역 페이지 - 검색 키워드를 기준으로 상품 검색 조회 DTO
 * @author 고재승
 * @since 2023.08.16
 */
@Data
public class OrderSearchParam {
	private int shopperNo;				// 회원번호
	private String searchKeyword;		// 검색 키워드 문자열
}
