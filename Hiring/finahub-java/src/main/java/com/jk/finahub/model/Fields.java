package com.jk.finahub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("Bank")
    @Expose
    private String bank;
    @SerializedName("Credit Card Count")
    @Expose
    private Integer creditCardCount;
    @SerializedName("Debit Card Count")
    @Expose
    private Integer debitCardCount;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getCreditCardCount() {
        return creditCardCount;
    }

    public void setCreditCardCount(Integer creditCardCount) {
        this.creditCardCount = creditCardCount;
    }

    public Integer getDebitCardCount() {
        return debitCardCount;
    }

    public void setDebitCardCount(Integer debitCardCount) {
        this.debitCardCount = debitCardCount;
    }

}