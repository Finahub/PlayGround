package com.finahub.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankInfo {

    @Id
    @GeneratedValue
    private int id;

    private String bankName;
    private int creditCount;
    private int debitCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }

    public int getDebitCount() {
        return debitCount;
    }

    public void setDebitCount(int debitCount) {
        this.debitCount = debitCount;
    }
}
