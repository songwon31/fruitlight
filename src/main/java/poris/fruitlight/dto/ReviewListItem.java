package poris.fruitlight.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author 송원석
 * @since 2023.09.13
 */
@Data
public class ReviewListItem {
	private int review_no;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date write_date;
    private String product_name;
    private String product_option;
    private String content;
}