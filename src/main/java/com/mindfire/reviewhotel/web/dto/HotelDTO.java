/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.web.dto;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        This HotelDTO Class is used for Taking Data From the hotel view.
 */
public class HotelDTO {

	private String hotelName;
	private String hotelLocation;
	private String hotelWebsite;
	private String hotelDescription;
	private String hotelCategory;
	private String hotelImage;

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName
	 *            the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the hotelLocation
	 */
	public String getHotelLocation() {
		return hotelLocation;
	}

	/**
	 * @param hotelLocation
	 *            the hotelLocation to set
	 */
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	/**
	 * @return the hotelWebsite
	 */
	public String getHotelWebsite() {
		return hotelWebsite;
	}

	/**
	 * @param hotelWebsite
	 *            the hotelWebsite to set
	 */
	public void setHotelWebsite(String hotelWebsite) {
		this.hotelWebsite = hotelWebsite;
	}

	/**
	 * @return the hotelDescription
	 */
	public String getHotelDescription() {
		return hotelDescription;
	}

	/**
	 * @param hotelDescription
	 *            the hotelDescription to set
	 */
	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	/**
	 * @return the hotelCategory
	 */
	public String getHotelCategory() {
		return hotelCategory;
	}

	/**
	 * @param hotelCategory
	 *            the hotelCategory to set
	 */
	public void setHotelCategory(String hotelCategory) {
		this.hotelCategory = hotelCategory;
	}

	/**
	 * @return the hotelImage
	 */
	public String getHotelImage() {
		return hotelImage;
	}

	/**
	 * @param hotelImage
	 *            the hotelImage to set
	 */
	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}

}
