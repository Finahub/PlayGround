package com.finahub.test.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields {
    @JsonProperty("Bank")
    String bank;
    @JsonProperty("Credit Card Count")
    int creditCardCount;
    @JsonProperty("Debit Card Count")
    int debitCardCount;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getCreditCardCount() {
        return creditCardCount;
    }

    public void setCreditCardCount(int creditCardCount) {
        this.creditCardCount = creditCardCount;
    }

    public int getDebitCardCount() {
        return debitCardCount;
    }

    public void setDebitCardCount(int debitCardCount) {
        this.debitCardCount = debitCardCount;
    }
}