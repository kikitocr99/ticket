package com.pinhost.mm.dtcdatabase.model;

import java.sql.Timestamp;
import java.util.List;

public class UserModel {
    private Long id;

    private String name;

    private String description;

    private Long roleId;

    private List<RoleModel> userRoles;

    private String password;

    private Timestamp passwordChangeDate;

    private int passwordErrorCount;

    private boolean enabled;

    private Timestamp deletedTime;

    private String deletedComment;

    private String firstName;

    private String familyName;

    private String userMailAddress;

    public UserModel(String name, List<RoleModel> userRoles, String password, boolean enabled) {
        this.name = name;
        this.userRoles = userRoles;
        this.password = password;
        this.enabled = enabled;
    }

    public UserModel() {
    }

    public UserModel(String name, String password, boolean enabled) {
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleModel> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<RoleModel> userRoles) {
        this.userRoles = userRoles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(Timestamp passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }

    public int getPasswordErrorCount() {
        return passwordErrorCount;
    }

    public void setPasswordErrorCount(int passwordErrorCount) {
        this.passwordErrorCount = passwordErrorCount;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Timestamp deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getDeletedComment() {
        return deletedComment;
    }

    public void setDeletedComment(String deletedComment) {
        this.deletedComment = deletedComment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getUserMailAddress() {
        return userMailAddress;
    }

    public void setUserMailAddress(String userMailAddress) {
        this.userMailAddress = userMailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", userRoles=" + userRoles +
                ", password='" + password + '\'' +
                ", passwordChangeDate=" + passwordChangeDate +
                ", passwordErrorCount=" + passwordErrorCount +
                ", enabled=" + enabled +
                ", deletedTime=" + deletedTime +
                ", deletedComment='" + deletedComment + '\'' +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", userMailAddress='" + userMailAddress + '\'' +
                '}';
    }
}
