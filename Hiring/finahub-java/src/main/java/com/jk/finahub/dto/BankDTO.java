package com.jk.finahub.dto;

import com.jk.finahub.model.Fields;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("bank")
public class BankDTO {
    @Id
    private Integer id;
    @Column("name")
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCreditCardCount() {
        return creditCardCount;
    }

    public void setCreditCardCount(String creditCardCount) {
        this.creditCardCount = creditCardCount;
    }

    public String getDebitCardCount() {
        return debitCardCount;
    }

    public void setDebitCardCount(String debitCardCount) {
        this.debitCardCount = debitCardCount;
    }

    @Column("ccc")
    private String creditCardCount; //credit card count
    @Column("dcc")
    private String debitCardCount; //debit card count

    public BankDTO(Fields fields) {
        setBank(fields.getBank());
        setCreditCardCount(fields.getCreditCardCount().toString());
        setDebitCardCount(fields.getDebitCardCount().toString());
    }
    public BankDTO(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

/*
  {
    "id": 1,
    "name": "ICICI",
    "ccc": "10",
    "dcc": "2"
  }
  or
  {
    "id": 2,
    "name": "HDFC",
    "ccc": "100",
    "dcc": "2"
  }
 */