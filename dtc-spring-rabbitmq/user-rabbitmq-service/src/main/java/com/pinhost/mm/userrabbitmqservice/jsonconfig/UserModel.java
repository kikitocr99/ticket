package com.pinhost.mm.userrabbitmqservice.jsonconfig;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pinhost.mm.dtcdatabase.model.RoleModel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UserModel implements Serializable {

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


    public UserModel() {
    }
    @JsonCreator
    public UserModel(@JsonProperty("id") Long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("roleId") Long roleId,
                     @JsonProperty("userRoles") List<RoleModel> userRoles,
                     @JsonProperty("password") String password,
                     @JsonProperty("passwordChangeDate") Timestamp passwordChangeDate,
                     @JsonProperty("passwordErrorCount") int passwordErrorCount,
                     @JsonProperty("enabled") boolean enabled,
                     @JsonProperty("deletedTime") Timestamp deletedTime,
                     @JsonProperty("deletedComment") String deletedComment,
                     @JsonProperty("firstName") String firstName,
                     @JsonProperty("familyName") String familyName,
                     @JsonProperty("userMailAddress") String userMailAddress) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roleId = roleId;
        this.userRoles = userRoles;
        this.password = password;
        this.passwordChangeDate = passwordChangeDate;
        this.passwordErrorCount = passwordErrorCount;
        this.enabled = enabled;
        this.deletedTime = deletedTime;
        this.deletedComment = deletedComment;
        this.firstName = firstName;
        this.familyName = familyName;
        this.userMailAddress = userMailAddress;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Long getRoleId() {
        return roleId;
    }


    public List<RoleModel> getUserRoles() {
        return userRoles;
    }

    public String getPassword() {
        return password;
    }


    public Timestamp getPasswordChangeDate() {
        return passwordChangeDate;
    }


    public int getPasswordErrorCount() {
        return passwordErrorCount;
    }


    public boolean isEnabled() {
        return enabled;
    }


    public Timestamp getDeletedTime() {
        return deletedTime;
    }


    public String getDeletedComment() {
        return deletedComment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getUserMailAddress() {
        return userMailAddress;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", roleId=" + roleId +
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
