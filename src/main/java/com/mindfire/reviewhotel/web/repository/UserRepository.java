/*
 * Copyright (c) Mindfire Solutions.  
 */
package com.mindfire.reviewhotel.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewhotel.web.domain.UserInfo;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 * 
 * Repository for {@link UserInfo} Entity.
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	
	
	public UserInfo findById(Long userId);
	public UserInfo findByUserName(String userName);
	public UserInfo findByUserEmail(String userEmail);
	
}
