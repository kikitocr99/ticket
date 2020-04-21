package com.pinhost.mm.dtcdatabase.model;

import java.sql.Timestamp;

public class RoleModel {
    private String name;

    private String description;

    private boolean deleted;

    private Timestamp deletedTime;

    private String deletedComment;

    public RoleModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    @Override
    public String toString() {
        return "RoleModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deleted=" + deleted +
                ", deletedTime=" + deletedTime +
                ", deletedComment='" + deletedComment + '\'' +
                '}';
    }
}
