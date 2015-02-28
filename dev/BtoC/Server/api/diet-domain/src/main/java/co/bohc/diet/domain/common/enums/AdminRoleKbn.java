package co.bohc.diet.domain.common.enums;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum AdminRoleKbn{
	SU("管理者",Collections.singletonList(new SimpleGrantedAuthority("ROLE_SU"))), 
	KE("管理栄養士",Collections.singletonList(new SimpleGrantedAuthority("ROLE_KE")));

    private final String label;
    
    private final List<SimpleGrantedAuthority> authorities;

    private AdminRoleKbn( String label,  List<SimpleGrantedAuthority> authorities) {
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
