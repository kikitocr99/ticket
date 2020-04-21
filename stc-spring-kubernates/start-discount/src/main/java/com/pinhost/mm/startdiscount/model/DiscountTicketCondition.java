package com.pinhost.mm.startdiscount.model;

import java.sql.Timestamp;

public class DiscountTicketCondition {
    private Integer id;

    private String name;

    private String description;

    private Timestamp conditionStart;

    private Timestamp conditionEnd;

    private Integer currentStatusId;

    private Integer ownerId;

    private Timestamp insertTime;

    private boolean deleted;

    private String deletedComment;

    private Integer discountTicketConditionTextId;

    private Integer stockId;

    private Integer discountTicketConditionTypeId;

    private boolean competition;

    private Integer customerType;

    public DiscountTicketCondition() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getConditionStart() {
        return conditionStart;
    }

    public void setConditionStart(Timestamp conditionStart) {
        this.conditionStart = conditionStart;
    }

    public Timestamp getConditionEnd() {
        return conditionEnd;
    }

    public void setConditionEnd(Timestamp conditionEnd) {
        this.conditionEnd = conditionEnd;
    }

    public Integer getCurrentStatusId() {
        return currentStatusId;
    }

    public void setCurrentStatusId(Integer currentStatusId) {
        this.currentStatusId = currentStatusId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDeletedComment() {
        return deletedComment;
    }

    public void setDeletedComment(String deletedComment) {
        this.deletedComment = deletedComment;
    }

    public Integer getDiscountTicketConditionTextId() {
        return discountTicketConditionTextId;
    }

    public void setDiscountTicketConditionTextId(Integer discountTicketConditionTextId) {
        this.discountTicketConditionTextId = discountTicketConditionTextId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getDiscountTicketConditionTypeId() {
        return discountTicketConditionTypeId;
    }

    public void setDiscountTicketConditionTypeId(Integer discountTicketConditionTypeId) {
        this.discountTicketConditionTypeId = discountTicketConditionTypeId;
    }

    public boolean isCompetition() {
        return competition;
    }

    public void setCompetition(boolean competition) {
        this.competition = competition;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "DiscountTicketCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", conditionStart=" + conditionStart +
                ", conditionEnd=" + conditionEnd +
                ", currentStatusId=" + currentStatusId +
                ", ownerId=" + ownerId +
                ", insertTime=" + insertTime +
                ", deleted=" + deleted +
                ", deletedComment='" + deletedComment + '\'' +
                ", discountTicketConditionTextId=" + discountTicketConditionTextId +
                ", stockId=" + stockId +
                ", discountTicketConditionTypeId=" + discountTicketConditionTypeId +
                ", competition=" + competition +
                ", customerType=" + customerType +
                '}';
    }
}
