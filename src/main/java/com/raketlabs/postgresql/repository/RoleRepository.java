package com.raketlabs.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raketlabs.postgresql.model.AdminRole;

@Repository("adminRoleRepository")
public interface RoleRepository extends JpaRepository<AdminRole, Integer> {

	AdminRole findByRole(String role);
}
