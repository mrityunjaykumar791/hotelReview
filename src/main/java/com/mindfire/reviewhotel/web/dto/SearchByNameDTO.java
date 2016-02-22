/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.web.dto;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        This SearchByNameDTO Class is used for Taking Data From the index
 *        view.
 */
public class SearchByNameDTO {

	private String hotelName;

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

}
