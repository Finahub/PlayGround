package com.finahub.demo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Bank",
        "Credit Card Count",
        "Debit Card Count"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankInfo {

    @Id
    @JsonAlias("Bank")
    private String bankName;
    @JsonAlias("Credit Card Count")
    private int creditCardCount;
    @JsonAlias("Debit Card Count")
    private int debitCardCount;

    public BankInfo() {
    }


}

