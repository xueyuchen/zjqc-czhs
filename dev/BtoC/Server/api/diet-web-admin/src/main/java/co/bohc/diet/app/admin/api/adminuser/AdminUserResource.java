package co.bohc.diet.app.admin.api.adminuser;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

import co.bohc.diet.domain.common.Environment;

public class AdminUserResource {

	private Integer adminUserId;

	@NotNull
	private String adminRoleKbn;

	@NotNull
	private String loginId;

	@NotNull
	private String adminUserName;

	@NotNull
	private String adminUserPhoto;

	private Integer delFlg;

	public Integer getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Integer delFlg) {
		this.delFlg = delFlg;
	}

	public Integer getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
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
		this.loginId = loginId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminUserPhoto() {
		if (!StringUtils.isEmpty(adminUserPhoto)) {
			return Environment.imgApi + adminUserPhoto;
		} else {
			return null;
		}
	}

	public void setAdminUserPhoto(String adminUserPhoto) {
		this.adminUserPhoto = adminUserPhoto;
	}

}
