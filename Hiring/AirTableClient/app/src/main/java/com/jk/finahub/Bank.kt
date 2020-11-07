package com.jk.finahub

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bank(val bank:String,
                val creditCardCount:String,
                val debitCardCount:String)

/*
  {
    "name": "ICICI",
    "ccc": "10",
    "dcc": "2"
  }
  or
  {
    "name": "HDFC",
    "ccc": "100",
    "dcc": "2"
  }
 */
