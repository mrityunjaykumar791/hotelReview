/*
 * Copyright (c) Mindfire Solutions.  
 */
package com.mindfire.reviewhotel.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfire.reviewhotel.web.domain.Hotel;
import com.mindfire.reviewhotel.web.domain.Review;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 * Repository for {@link Review} Entity.
 */
public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	public Review findById(Long id);
	
	public List<Review> findByHotelIdOrderByReviewDateDesc(Hotel hotelId);
	
	@Transactional
	public void delete(Review review);
	
	

}
