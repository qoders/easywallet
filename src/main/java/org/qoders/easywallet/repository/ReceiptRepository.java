package org.qoders.easywallet.repository;

import java.util.List;

import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReceiptRepository extends CrudRepository <Receipt, Long>{
	@Query("SELECT r FROM Receipt r WHERE r.owner=:user")
	public List<Receipt> findByUser(@Param("user") User user);
}
