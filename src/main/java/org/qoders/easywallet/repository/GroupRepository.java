package org.qoders.easywallet.repository;

import java.util.List;

import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
	
	@Query("SELECT g FROM WalletGroup g WHERE g.owner=:user")
	public List<Group> findByUser(@Param("user") User user);

}
