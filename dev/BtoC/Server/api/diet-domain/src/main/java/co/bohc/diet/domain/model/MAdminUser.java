package co.bohc.diet.domain.model;

// Generated 2015-4-17 18:10:39 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * MAdminUser generated by hbm2java
 */
@Entity
@Table(name = "m_admin_user", schema = "dbo", uniqueConstraints = @UniqueConstraint(columnNames = "login_id"))
public class MAdminUser implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer adminUserId;
    private String password;
    private String adminRoleKbn;
    private String loginId;
    private String adminUserName;
    private String adminUserPhoto;
    private Date creDt;
    private Date updDt;
    private Integer creUserId;
    private Integer updUserId;
    private Integer delFlg;
    private Set<TUser> TUsers = new HashSet<TUser>(0);

    public MAdminUser() {
    }

    public MAdminUser(Integer adminUserId, String password, String adminRoleKbn, String loginId, Date creDt,
            Date updDt, Integer creUserId, Integer updUserId, Integer delFlg) {
        this.adminUserId = adminUserId;
        this.password = password;
        this.adminRoleKbn = adminRoleKbn;
        this.loginId = loginId;
        this.creDt = creDt;
        this.updDt = updDt;
        this.creUserId = creUserId;
        this.updUserId = updUserId;
        this.delFlg = delFlg;
    }

    public MAdminUser(Integer adminUserId, String password, String adminRoleKbn, String loginId, String adminUserName,
            String adminUserPhoto, Date creDt, Date updDt, Integer creUserId, Integer updUserId, Integer delFlg,
            Set<TUser> TUsers) {
        this.adminUserId = adminUserId;
        this.password = password;
        this.adminRoleKbn = adminRoleKbn;
        this.loginId = loginId;
        this.adminUserName = adminUserName;
        this.adminUserPhoto = adminUserPhoto;
        this.creDt = creDt;
        this.updDt = updDt;
        this.creUserId = creUserId;
        this.updUserId = updUserId;
        this.delFlg = delFlg;
        this.TUsers = TUsers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_user_id", unique = true, nullable = false)
    public Integer getAdminUserId() {
        return this.adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    @Column(name = "password", nullable = false, length = 256)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "admin_role_kbn", nullable = false, length = 2)
    public String getAdminRoleKbn() {
        return this.adminRoleKbn;
    }

    public void setAdminRoleKbn(String adminRoleKbn) {
        this.adminRoleKbn = adminRoleKbn;
    }

    @Column(name = "login_id", unique = true, nullable = false, length = 30)
    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Column(name = "admin_user_name", length = 20)
    public String getAdminUserName() {
        return this.adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    @Column(name = "admin_user_photo", length = 256)
    public String getAdminUserPhoto() {
        return this.adminUserPhoto;
    }

    public void setAdminUserPhoto(String adminUserPhoto) {
        this.adminUserPhoto = adminUserPhoto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cre_dt", nullable = false, length = 23)
    public Date getCreDt() {
        return this.creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_dt", nullable = false, length = 23)
    public Date getUpdDt() {
        return this.updDt;
    }

    public void setUpdDt(Date updDt) {
        this.updDt = updDt;
    }

    @Column(name = "cre_user_id", nullable = false)
    public Integer getCreUserId() {
        return this.creUserId;
    }

    public void setCreUserId(Integer creUserId) {
        this.creUserId = creUserId;
    }

    @Column(name = "upd_user_id", nullable = false)
    public Integer getUpdUserId() {
        return this.updUserId;
    }

    public void setUpdUserId(Integer updUserId) {
        this.updUserId = updUserId;
    }

    @Column(name = "del_flg", nullable = false)
    public Integer getDelFlg() {
        return this.delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "MAdminUser")
    public Set<TUser> getTUsers() {
        return this.TUsers;
    }

    public void setTUsers(Set<TUser> TUsers) {
        this.TUsers = TUsers;
    }

}
