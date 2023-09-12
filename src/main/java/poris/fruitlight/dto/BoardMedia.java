package poris.fruitlight.dto;

import lombok.Data;

/**
 * 게시글의 미디어 파일 정보 DTO
 * @author 고재승
 * @since 2023.08.16
 */
@Data
public class BoardMedia {
	private int mediaNo;			// 미디어 파일 고유번호
	private int boardNo;			// 게시글 고유번호
	private String mediaName;		// 미디어 파일 이름
	private byte[] mediaData;		// 미디터 파일 MetaData
	private String base64Img;		// base64Img 인코딩
}
