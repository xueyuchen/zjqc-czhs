package co.bohc.diet.domain.common.enums;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import co.bohc.diet.domain.common.constants.Constants;

public enum UserRoleKbn {
	
	USER("USER",Collections.singletonList(new SimpleGrantedAuthority(Constants.ROLE_USER))), 
	UNPAID_USER("UNPAID_USER",Collections.singletonList(new SimpleGrantedAuthority(Constants.ROLE_UNPAID_USER))),
	TRIAL_USER("TRIAL_USER",Collections.singletonList(new SimpleGrantedAuthority(Constants.ROLE_TRIAL_USER))),
	EXPIRED_USER("EXPIRED_USER",Collections.singletonList(new SimpleGrantedAuthority(Constants.ROLE_EXPIRED_USER)));

    private final String label;
    
    private final List<SimpleGrantedAuthority> authorities;

    private UserRoleKbn( String label,  List<SimpleGrantedAuthority> authorities) {
        this.label = label;
        this.authorities = authorities;
    }

    public String getLabel() {
        return label;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}

}
