package com.raketlabs.postgresql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raketlabs.postgresql.model.AdminRole;
import com.raketlabs.postgresql.model.AdminUser;
import com.raketlabs.postgresql.repository.AdminUserRepository;
import com.raketlabs.postgresql.repository.RoleRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Autowired
	private RoleRepository adminRoleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AdminUser findByUsername(String username) {
		return adminUserRepository.findByUsername(username);
	}

	@Override
	public void saveAdminUser(AdminUser adminUser) {
		adminUser.setPassword(bCryptPasswordEncoder.encode(adminUser.getPassword()));
		adminUser.setActivity(1);
		AdminRole role = adminRoleRepository.findByRole("ADMIN");
		//adminUser.setRoles(new HashSet<AdminRole>(Arrays.asList(role)));
		adminUserRepository.save(adminUser);
	}

	
}
