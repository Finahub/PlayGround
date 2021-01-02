package com.finahub.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.finahub.demo.model.BankInfo;
import lombok.Getter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "fields",
        "createdTime"
})
@JsonIgnoreProperties(ignoreUnknown = true)

public class Record {

    @JsonProperty("id")
    private String id;
    @JsonProperty("fields")
    private BankInfo bankInfo;
    @JsonProperty("createdTime")
    private String createdTime;

    public BankInfo getBankInfo() {
        return bankInfo;
    }

}
