package com.raketlabs.postgresql.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.raketlabs.postgresql.model.AdminUser;
import com.raketlabs.postgresql.service.AdminUserService;

@Configuration
public class WebmvcConfig implements WebMvcConfigurer {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	
	@Autowired
	AdminUserService mUserDetailService;
	
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
// 
//        
//        String encodedPassword = passwordEncoder().encode("password");
//        
//        manager.createUser(User.builder().username("user").password(encodedPassword).roles("USER").build());
//        
        
        
        return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				AdminUser user = mUserDetailService.findByUsername(username);
				
				if (user == null) {
		            throw new UsernameNotFoundException(username);
		        }
				
				return new UserDetails() {

					@Override
					public Collection<? extends GrantedAuthority> getAuthorities() {
						final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("User"));
						return authorities;
					}

					@Override
					public String getPassword() {
						return user.getPassword();
					}

					@Override
					public String getUsername() {
						return user.getUsername();
					}

					@Override
					public boolean isAccountNonExpired() {
						return true;
					}

					@Override
					public boolean isAccountNonLocked() {
						return true;
					}

					@Override
					public boolean isCredentialsNonExpired() {
						return true;
					}

					@Override
					public boolean isEnabled() {
						return true;
					}};
				
			}
        	
        };
        

    }
	
}