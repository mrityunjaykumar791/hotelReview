/*
 * Copyright (c) Mindfire Solutions.
 */
package com.mindfire.reviewhotel.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewhotel.web.domain.Hotel;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 * Repository for {@link Hotel} Entity.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	public List<Hotel> findByHotelNameIgnoreCaseContaining(String hotelName);
	
	public List<Hotel> findByHotelLocationIgnoreCaseContaining(String hotelLocation);
	
	public List<Hotel> findByHotelCategoryIgnoreCaseContaining(String hotelCategory);
	
	public Hotel findById(Long hotelId);

}
