/**
 * 
 */
package com.mindfire.reviewhotel.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewhotel.web.domain.UserInfo;

/**
 * @author mindfire
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	
	
	public UserInfo findById(Long userId);
	public UserInfo findByUserName(String userName);
	public UserInfo findByUserEmail(String userEmail);
	
}
