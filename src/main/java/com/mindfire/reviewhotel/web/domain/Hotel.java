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
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 * 
 * Hotel Class is used as Entity Class for hotel details.
 */

@Entity
@Table(name="hotel")
@NamedNativeQuery(name="hotel.All", query = "SELECT h FROM hotel h")
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="h_id")
	private Long id;
	
	@Column(name="hotel_name", nullable = false)
	private String hotelName;
	
	@Column(name="hotel_location", nullable = false)
	private String hotelLocation;
	
	@Column(name="hotel_description", nullable = false)
	private String hotelDescription;
	
	@Column(name="hotel_website", nullable = false)
	private String hotelWebsite;
	
	@Column(name="hotel_category",nullable = false)
	private String hotelCategory;
	
	@Column(name="hotel_image")
	private String hotelImage;
	
	@Column(name = "uploaded_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp uploadedDate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getHotelWebsite() {
		return hotelWebsite;
	}

	public void setHotelWebsite(String hotelWebsite) {
		this.hotelWebsite = hotelWebsite;
	}

	public String getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}

	public Long getId() {
		return id;
	}

	public Timestamp getUploadedDate() {
		return uploadedDate;
	}

	public String getHotelCategory() {
		return hotelCategory;
	}

	public void setHotelCategory(String hotelCategory) {
		this.hotelCategory = hotelCategory;
	}
}
