package com.jk.finahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.table_view.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startApp()
    }

    private fun startApp() {
//        getAllSavedBanksDB() // just get all bank data from local server
        getRandomAirTable()
        val model = ViewModelProvider(this)[BankViewModel::class.java]


        saveLocalData.setOnClickListener {
            model.post(getUIData())
        }
    }

    private fun getRandomAirTable() {
        val model = ViewModelProvider(this)[BankViewModel::class.java]

        model.getRandomAirTableData()

        model.successResponse.observe( this ,  {
            println("success")
            toUI(it[0])
        })

        model.failedResponse.observe(this, {
            println(it)
            show(saveLocalData, it)
            disableSaveButton()
        })
    }


    private fun getAllSavedBanksDB() {
        val model = ViewModelProvider(this)[BankViewModel::class.java]

        model.getAllBanksSavedDB()

        model.successResponse.observe( this ,  {
            println("success")
            toUI(it[0])
        })

        model.failedResponse.observe(this, {
            println(it)
            show(saveLocalData, it)
            disableSaveButton()
        })


    }

    private fun toUI(bank: Bank) {

        bank_name.text = bank.bank
        bank_ccc.text = bank.creditCardCount
        bank_dcc.text = bank.debitCardCount

    }

    private fun getUIData(): Bank = Bank(
        bank_name.text.toString(),
        bank_ccc.text.toString(),
        bank_dcc.text.toString()
    )


    private fun disableSaveButton() {
        "Just disable it"
    }
}