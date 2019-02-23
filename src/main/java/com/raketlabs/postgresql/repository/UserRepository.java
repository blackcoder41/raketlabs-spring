package com.raketlabs.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raketlabs.postgresql.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
