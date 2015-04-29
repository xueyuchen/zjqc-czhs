package co.bohc.diet.domain.service.security;

import java.util.Collection;

import co.bohc.diet.domain.common.utils.TimeUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.security.core.GrantedAuthority;

import co.bohc.diet.domain.common.enums.DelFlg;
import co.bohc.diet.domain.common.enums.UserRoleKbn;
import co.bohc.diet.domain.model.TUser;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BohUserDetails implements CustomUserDetails {

    private static final long serialVersionUID = 1L;

    private final TUser tUser;
    private final int payDurationInDay;
    private final String tExamStatusKbn;

    public BohUserDetails(TUser tUser, int payDurationInDay, String tExamStatusKbn) {
        this.tUser = tUser;
        this.payDurationInDay = payDurationInDay;
        this.tExamStatusKbn = tExamStatusKbn;
    }

    private boolean isExpired() {
        if (tUser.getStartRecDate() != null) {

            DateTime activeDate = DateTime.parse(tUser.getStartRecDate());
            int leftServiceDay = payDurationInDay - Days.daysBetween(activeDate, DateTime.now()).getDays();

            if (leftServiceDay <= 0){
                return true;
            }
        }
        return false;
    }

    private boolean isTrial() {
        // 測定日付がnullもしくは現在日付であればtrueを返す。
        return tUser.getStartRecDate() == null || !TimeUtils.isPast(tUser.getStartRecDate());

    }


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getUserRoleKbn().getAuthorities();
    }

    @JsonIgnore
    private UserRoleKbn getUserRoleKbn() {

        if (false){
            return UserRoleKbn.UNPAID_USER;
        } else if (isTrial()){
            return UserRoleKbn.TRIAL_USER;
        } else if (isExpired()) {
            return UserRoleKbn.EXPIRED_USER;
        } else {
            return UserRoleKbn.USER;
        }
    }
//    @JsonIgnore
//    private UserRoleKbn getUserRoleKbn() {
//
//        if (ExamStatus.SS.toString().equals(this.tExamStatusKbn)){
//            return UserRoleKbn.UNPAID_USER;
//        } else if (isTrial()){
//            return UserRoleKbn.TRIAL_USER;
//        } else if (isExpired()) {
//            return UserRoleKbn.EXPIRED_USER;
//        } else {
//            return UserRoleKbn.USER;
//        }
//    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.tUser.getPassword();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.tUser.getEmail();
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
        return DelFlg.OFF.getValue().equals(this.tUser.getDelFlg());
    }

    public Integer getUserId() {
        return tUser.getUserId();
    }

    public String getEmail() {
        return tUser.getEmail();
    }

    @Override
    @JsonIgnore
    public Integer getId() {
        return tUser.getUserId();
    }

    public String getRoleKbn() {
        return this.getUserRoleKbn().getLabel();
    }

    @JsonProperty("examStatusKbn")
    public String getTExamStatusKbn() {
        return tExamStatusKbn;
    }


}
