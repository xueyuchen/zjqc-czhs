package co.bohc.diet.domain.service.adminuser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;



public class AdminUserInput {

	@NotNull
	private Integer adminUserId;
	
	@Pattern(regexp = "^?[a-zA-Z0-9]{8,12}$")
	private String password;
	
	@Length(max = 2)
	private String adminRoleKbn;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{0,30}$")
	private String loginId;
	
    @Length(max = 20)
	private String adminUserName;
	
	private MultipartFile headerFile;
	
	public MultipartFile getHeaderFile() {
		return headerFile;
	}

	public void setHeaderFile(MultipartFile headerFile) {
		this.headerFile = headerFile;
	}

	public Integer getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = (StringUtils.isEmpty(password)?null:password);
	}

	public String getAdminRoleKbn() {
		return adminRoleKbn;
	}

	public void setAdminRoleKbn(String adminRoleKbn) {
		this.adminRoleKbn = adminRoleKbn;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = (StringUtils.isEmpty(loginId)?null:loginId);
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = (StringUtils.isEmpty(adminUserName)?null:adminUserName);
	}

}
