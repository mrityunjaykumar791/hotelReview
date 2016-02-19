/**
 * 
 */
package com.mindfire.reviewhotel.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewhotel.web.domain.Hotel;

/**
 * @author mindfire
 *
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	public List<Hotel> findByHotelName(String hotelName);
	
	public List<Hotel> findByHotelLocationIgnoreCaseContaining(String hotelLocation);
	
	public List<Hotel> findByHotelCategoryIgnoreCaseContaining(String hotelCategory);
	
	public Hotel findById(Long hotelId);

}
