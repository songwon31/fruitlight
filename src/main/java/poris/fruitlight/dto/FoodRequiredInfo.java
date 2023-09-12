package poris.fruitlight.dto;

import lombok.Data;

/**
 * 식품위생안전법에 따른 상품 필수 표기 정보 DTO
 * @author 고재승
 * @since 2023.08.16
 */
@Data
public class FoodRequiredInfo {
	private int boardNo;							// 게시글 번호(PK)
	private String item;							// 상품 품목
	private String weight;							// 상품 중량
	private String producer;						// 생산자
	private String origin;							// 생산지
	private String productionDate;					// 생산 날짜
	private String detail;							// 제품 세부정보
	private String importedFoodStatement;			// 수입식품문구
	private String composition;						// 상품 구성
	private String storageType;						// 보관 방법
	private String precaution;						// 주의 사항
	private String csContact;						// 소비자상담번호
}
