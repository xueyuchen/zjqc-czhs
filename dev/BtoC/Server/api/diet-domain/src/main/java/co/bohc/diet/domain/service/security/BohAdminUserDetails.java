package co.bohc.diet.domain.service.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.bohc.diet.domain.common.enums.AdminRoleKbn;
import co.bohc.diet.domain.common.enums.DelFlg;
import co.bohc.diet.domain.model.MAdminUser;

public class BohAdminUserDetails implements CustomUserDetails {
    
    private static final long serialVersionUID = 1L;

    private final MAdminUser mAdminUser;

    public BohAdminUserDetails(MAdminUser mAdminUser) {
        this.mAdminUser = mAdminUser;
    }
        
    public static BohAdminUserDetails currentUserDetails() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((BohAdminUserDetails) principal);
            }
        }
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	return AdminRoleKbn.valueOf(this.mAdminUser.getAdminRoleKbn()).getAuthorities();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.mAdminUser.getPassword();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.mAdminUser.getLoginId();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return DelFlg.OFF.getValue().equals(this.mAdminUser.getDelFlg());
    }

    public String getAdminRoleKbn(){
    	return mAdminUser.getAdminRoleKbn();
    }
    
    public Integer getAdminUserId(){
    	return mAdminUser.getAdminUserId();
    }
 	
	public String getLoginId() {

		return mAdminUser.getLoginId();
	}

	public String getAdminUserName() {
		return mAdminUser.getAdminUserName();
	}

	public String getAdminUserPhoto() {
		return mAdminUser.getAdminUserPhoto();
	}

	@Override
    @JsonIgnore
	public Integer getId() {
		return mAdminUser.getAdminUserId();
	}

}
