package poris.fruitlight.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.ReviewListItem;
import poris.fruitlight.service.ReviewService;

/**
 * @author 송원석
 */
@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {
	@Resource
	private ReviewService reviewService;
	
	@GetMapping(value="/getReviewList", produces="application/json; charset=UTF-8")
	public List<ReviewListItem> getReviewList() {
		return reviewService.getReviewList();
	}
	
	
}
