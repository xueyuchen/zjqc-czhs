package co.bohc.diet.domain.service.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {

	public Integer getId();
}

