package org.qoders.easywallet.repository;

import org.qoders.easywallet.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Nhu Trinh
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	public User findByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.email=:email")
	public User findByEmail(@Param("email") String email);
	
}
