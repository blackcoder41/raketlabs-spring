package com.raketlabs.postgresql.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	private final String AdminUser_Query = "select email, password, activity from user where email=?";
	private final String AdminRole_Query = "select u.email, r.role from adminuser u inner join role "
			+ "ur on (u.id = ur.adminuser_id) inner join role r on (ur.id = r.id) where u.email=?";

<<<<<<< HEAD
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(AdminUser_Query).authoritiesByUsernameQuery(AdminRole_Query)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
=======
		
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/login2").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/view_questions").permitAll()
			.antMatchers("/signup").permitAll()
			.antMatchers("/css/**").permitAll().anyRequest().permitAll()
			.antMatchers("/js/**").permitAll().anyRequest().permitAll()
			.antMatchers("/home/**").hasAuthority("ADMIN").anyRequest()
			.authenticated().and().csrf().disable()
			.formLogin().loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/home/home")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/foo")
			.and().rememberMe()
			.tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(60*60)
			.and().exceptionHandling().accessDeniedPage("/access_denied");
>>>>>>> refs/remotes/github/master
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/login2").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/view_questions").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/css/**").permitAll().anyRequest().permitAll()
		.antMatchers("/js/**").permitAll().anyRequest().permitAll()
		.antMatchers("/home/**")
				.hasAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/home/home")
				.usernameParameter("email").passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/foo").and().rememberMe()
				.tokenRepository(persistentTokenRepository()).tokenValiditySeconds(60 * 60).and().exceptionHandling()
				.accessDeniedPage("/access_denied");
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);

		return db;
	}
}
