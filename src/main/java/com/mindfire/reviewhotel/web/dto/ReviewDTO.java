/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.web.dto;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        This ReviewDTO Class is used for Taking Data From the hotelTemplate
 *        view.
 */
public class ReviewDTO {

	private String reviewComment;
	private int ratingValue;

	private Long hotelId;
	private Long userId;

	/**
	 * @return the reviewComment
	 */
	public String getReviewComment() {
		return reviewComment;
	}

	/**
	 * @param reviewComment
	 *            the reviewComment to set
	 */
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	/**
	 * @return the ratingValue
	 */
	public int getRatingValue() {
		return ratingValue;
	}

	/**
	 * @param ratingValue
	 *            the ratingValue to set
	 */
	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	/**
	 * @return the hotelId
	 */
	public Long getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId
	 *            the hotelId to set
	 */
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
