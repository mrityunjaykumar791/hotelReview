/**
 * 
 */
package com.mindfire.reviewhotel.web.dto;

/**
 * @author mindfire
 *
 */
public class ReviewDTO {
	
	private String reviewComment;
	private int ratingValue;
	
	private Long hotelId;
	private Long userId;
	
	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReviewComment() {
		return reviewComment;
	}
	
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	
	public int getRatingValue() {
		return ratingValue;
	}
	
	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}
	
}
