/**
 * 
 */
package com.mindfire.reviewhotel.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfire.reviewhotel.web.domain.Hotel;
import com.mindfire.reviewhotel.web.domain.Review;

/**
 * @author mindfire
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	public List<Review> findById(Long id);
	
	public List<Review> findByHotelId(Hotel hotelId);

}
