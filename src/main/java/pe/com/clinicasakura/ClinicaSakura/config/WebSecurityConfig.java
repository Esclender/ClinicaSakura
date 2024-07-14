package pe.com.clinicasakura.ClinicaSakura.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import pe.com.clinicasakura.ClinicaSakura.service.security.impl.CustomUserDetailsService;
import pe.com.clinicasakura.ClinicaSakura.utils.JwtUtil;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/", "/login", "/css/**").permitAll()
						.anyRequest().authenticated())
				.authenticationProvider(authenticationProvider()).addFilterBefore(
						jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class)
				.formLogin((form) -> form
						.loginPage("/login")
						.defaultSuccessUrl("/inicio", true)
						.permitAll())
				.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public JwtFilterConfig jwtRequestFilter() {
		return new JwtFilterConfig(jwtUtil, customUserDetailsService);
	}
}
