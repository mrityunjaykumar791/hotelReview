/*
 * Copyright (c) Mindfire Solutions.  
 */
package com.mindfire.reviewhotel.web.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 * 
 * Review Class is used as Entity Class for review details.
 */
@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;

	@Column(name="review_comment", nullable=false)
	private String reviewComment;
	
	@Column(name="rating_value", nullable=false)
	private int ratingValue;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName ="u_id")
	private UserInfo userId;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName ="h_id")
	private Hotel hotelId;
	
	@Column(name = "review_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp reviewDate;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the reviewComment
	 */
	public String getReviewComment() {
		return reviewComment;
	}
	
	/**
	 * @param reviewComment the reviewComment to set
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
	 * @param ratingValue the ratingValue to set
	 */
	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}
	
	/**
	 * @return the userId
	 */
	public UserInfo getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UserInfo userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the hotelId
	 */
	public Hotel getHotelId() {
		return hotelId;
	}
	
	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(Hotel hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the reviewDate
	 */
	public Timestamp getReviewDate() {
		return reviewDate;
	}

	/**
	 * @param reviewDate the reviewDate to set
	 */
	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}
