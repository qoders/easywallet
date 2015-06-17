package org.qoders.easywallet.repository;

import java.util.List;

import org.qoders.easywallet.domain.Companion;
import org.qoders.easywallet.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanionRepository extends CrudRepository<Companion, Long>{
	
	@Query("SELECT c FROM Companion c WHERE c.owner=:user")
	public List<Companion> findAllByOwner(@Param("user") User user);
	
	@Query("SELECT c FROM Companion c WHERE c.companion=:user")
	public List<Companion> findAllByUser(@Param("user") User user);
	
	@Query("SELECT c FROM Companion c WHERE c.owner=:user AND c.settle is true")
	public List<Companion> findNotSettleByOwner(@Param("user") User user);
	
	@Query("SELECT c FROM Companion c WHERE c.companion=:user AND c.settle is true")
	public List<Companion> findNotSettleByUser(@Param("user") User user);
	
}
