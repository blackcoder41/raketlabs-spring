package com.raketlabs.postgresql.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.raketlabs.postgresql.service.AdminUserService;
import com.raketlabs.postgresql.service.AdminUserServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("com.raketlabs.postgresql.service")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	private final String AdminUser_Query = "select email, password, activity from user where email=?";
	private final String AdminRole_Query = "select u.email, r.role from adminuser u inner join role "
			+ "ur on (u.id = ur.adminuser_id) inner join role r on (ur.id = r.id) where u.email=?";

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// blackcoder@gmail.com
		
		http.authorizeRequests()

		.antMatchers("/").permitAll()
		.antMatchers("/questions").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/login3").permitAll()
		.antMatchers("/login2").permitAll()
		.antMatchers("/login4").permitAll()
		.antMatchers("/view_questions").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login?error=true")
		.defaultSuccessUrl("/home/home")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/foo")
		.and().rememberMe()
		.and().exceptionHandling()
		.accessDeniedPage("/access_denied");
	}
	
	//christian
	
}
