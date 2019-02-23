package com.raketlabs.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raketlabs.postgresql.model.AdminUser;

@Repository("adminUserRepository")
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
	
	AdminUser findByUsername(String username);

}
