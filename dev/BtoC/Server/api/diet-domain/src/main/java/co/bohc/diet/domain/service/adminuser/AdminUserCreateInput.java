package co.bohc.diet.domain.service.adminuser;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import co.bohc.diet.domain.common.enums.RoleKbn;

public class AdminUserCreateInput {

	@Pattern(regexp = "^[a-zA-Z0-9]{8,12}$")
	private String password;
	
	@Length(max = 2)
	private String adminRoleKbn;
	
	@NotBlank
	@Length(max = 30)
	private String loginId;
	
	@NotBlank
	@Length(max = 20)
	private String adminUserName;
	
	private MultipartFile headerFile;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminRoleKbn() {
		if(adminRoleKbn == null || adminRoleKbn.equals("")){
			return RoleKbn.KE.getLabel();
		}
		return adminRoleKbn;
	}

	public void setAdminRoleKbn(String adminRoleKbn) {
		this.adminRoleKbn = adminRoleKbn;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public MultipartFile getHeaderFile() {
		return headerFile;
	}

	public void setHeaderFile(MultipartFile headerFile) {
		this.headerFile = headerFile;
	}

}
