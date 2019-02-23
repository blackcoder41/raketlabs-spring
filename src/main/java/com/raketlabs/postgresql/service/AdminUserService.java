package com.raketlabs.postgresql.service;

import com.raketlabs.postgresql.model.AdminUser;

public interface AdminUserService {

	public AdminUser findByUsername(String username);
	
	public void saveAdminUser(AdminUser adminUser);
}
