/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.web.dto;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 *        This SearchDTO Class is used for Taking Data From the searchByLocation
 *        view.
 */
public class SearchDTO {

	private String hotelLocation;

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

}
