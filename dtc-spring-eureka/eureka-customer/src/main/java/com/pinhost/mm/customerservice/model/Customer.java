package com.pinhost.mm.customerservice.model;

import java.sql.Timestamp;

public class Customer {
    private Integer id;
    private String name;
    private String pioneId;
    private String khkId;
    private Integer payInterval;
    private Integer creditLimit;
    private Integer reachedCreditLimit;
    private Timestamp lastPayDay;
    private String identifyNumber;
    private String iln;
    private Integer parentId;
    private Timestamp insertDate;
    private String taxNumber;
    private Integer taxOfficeId;
    private String costUnitIln;
    private Integer multiClientCapabilityId;

    public Customer() {
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

    public String getPioneId() {
        return pioneId;
    }

    public void setPioneId(String pioneId) {
        this.pioneId = pioneId;
    }

    public String getKhkId() {
        return khkId;
    }

    public void setKhkId(String khkId) {
        this.khkId = khkId;
    }

    public Integer getPayInterval() {
        return payInterval;
    }

    public void setPayInterval(Integer payInterval) {
        this.payInterval = payInterval;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getReachedCreditLimit() {
        return reachedCreditLimit;
    }

    public void setReachedCreditLimit(Integer reachedCreditLimit) {
        this.reachedCreditLimit = reachedCreditLimit;
    }

    public Timestamp getLastPayDay() {
        return lastPayDay;
    }

    public void setLastPayDay(Timestamp lastPayDay) {
        this.lastPayDay = lastPayDay;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getIln() {
        return iln;
    }

    public void setIln(String iln) {
        this.iln = iln;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Integer getTaxOfficeId() {
        return taxOfficeId;
    }

    public void setTaxOfficeId(Integer taxOfficeId) {
        this.taxOfficeId = taxOfficeId;
    }

    public String getCostUnitIln() {
        return costUnitIln;
    }

    public void setCostUnitIln(String costUnitIln) {
        this.costUnitIln = costUnitIln;
    }

    public Integer getMultiClientCapabilityId() {
        return multiClientCapabilityId;
    }

    public void setMultiClientCapabilityId(Integer multiClientCapabilityId) {
        this.multiClientCapabilityId = multiClientCapabilityId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pioneId='" + pioneId + '\'' +
                ", khkId='" + khkId + '\'' +
                ", payInterval=" + payInterval +
                ", creditLimit=" + creditLimit +
                ", reachedCreditLimit=" + reachedCreditLimit +
                ", lastPayDay=" + lastPayDay +
                ", identifyNumber='" + identifyNumber + '\'' +
                ", iln='" + iln + '\'' +
                ", parentId=" + parentId +
                ", insertDate=" + insertDate +
                ", taxNumber='" + taxNumber + '\'' +
                ", taxOfficeId=" + taxOfficeId +
                ", costUnitIln='" + costUnitIln + '\'' +
                ", multiClientCapabilityId=" + multiClientCapabilityId +
                '}';
    }
}
