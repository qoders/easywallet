package org.qoders.easywallet.repository;

import org.qoders.easywallet.domain.Verification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends CrudRepository<Verification, Long> {
	@Query("SELECT u FROM Verification u WHERE u.email=:email AND u.verificationCode=:code")
	public Verification verify(@Param("email") String email,@Param("code")  String code);
}
