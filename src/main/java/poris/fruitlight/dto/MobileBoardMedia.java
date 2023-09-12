package poris.fruitlight.dto;

import lombok.Data;

/**
 * 게시글의 미디어 파일 정보 DTO
 * @author 고재승
 * @since 2023.08.16
 */
@Data
public class MobileBoardMedia {
	private int media_no;			// 미디어 파일 고유번호
	private int board_no;			// 게시글 고유번호
	private String media_name;		// 미디어 파일 이름
	private byte[] media_data;		// 미디터 파일 MetaData
}
