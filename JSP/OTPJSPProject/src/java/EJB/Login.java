/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

/**
 *
 * @author osama
 */
public class Login {
    private int LoginId;
    private String UserId;
    private String Password;
    private int RoleId;
    private String RegistrationOrUserId;
    private String AccessibilityStatus;
    private String CreatedBy;
    private String CreatedDateTime;
    private String EnabledBy;
    private String EnabledDateTime;

    public Login() {
    }

    public Login(int LoginId, String UserId, String Password, int RoleId, String RegistrationOrUserId, String AccessibilityStatus, String CreatedBy, String CreatedDateTime, String EnabledBy, String EnabledDateTime) {
        this.LoginId = LoginId;
        this.UserId = UserId;
        this.Password = Password;
        this.RoleId = RoleId;
        this.RegistrationOrUserId = RegistrationOrUserId;
        this.AccessibilityStatus = AccessibilityStatus;
        this.CreatedBy = CreatedBy;
        this.CreatedDateTime = CreatedDateTime;
        this.EnabledBy = EnabledBy;
        this.EnabledDateTime = EnabledDateTime;
    }

    public int getLoginId() {
        return LoginId;
    }

    public void setLoginId(int LoginId) {
        this.LoginId = LoginId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }

    public String getRegistrationOrUserId() {
        return RegistrationOrUserId;
    }

    public void setRegistrationOrUserId(String RegistrationOrUserId) {
        this.RegistrationOrUserId = RegistrationOrUserId;
    }

    public String getAccessibilityStatus() {
        return AccessibilityStatus;
    }

    public void setAccessibilityStatus(String AccessibilityStatus) {
        this.AccessibilityStatus = AccessibilityStatus;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public String getCreatedDateTime() {
        return CreatedDateTime;
    }

    public void setCreatedDateTime(String CreatedDateTime) {
        this.CreatedDateTime = CreatedDateTime;
    }

    public String getEnabledBy() {
        return EnabledBy;
    }

    public void setEnabledBy(String EnabledBy) {
        this.EnabledBy = EnabledBy;
    }

    public String getEnabledDateTime() {
        return EnabledDateTime;
    }

    public void setEnabledDateTime(String EnabledDateTime) {
        this.EnabledDateTime = EnabledDateTime;
    }
    
    
}
