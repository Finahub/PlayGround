package com.jk.finahub

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jk.finahub.callback.ApiCallback
import com.jk.finahub.call.ApiCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class BankViewModel : ViewModel() {
    //create a new Job
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    //create a coroutine scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)

    val successResponse = MutableLiveData<List<Bank>>()
    val failedResponse = MutableLiveData<String>()

    fun getAllBanksSavedDB() {
        ///launch the coroutine scope
        scope.launch {
            ApiCall.getAllBanksSavedDB(object : ApiCallback {
                override fun onSuccess(list: List<Bank>) {
                    successResponse.postValue(list)
                }

                override fun onFailed(msg: String) {
                    failedResponse.postValue(msg)
                }
            })
        }
    }

    fun getRandomAirTableData() {
        ///launch the coroutine scope
        scope.launch {
            ApiCall.getOneBankFromAirTable(object : ApiCallback {
                override fun onSuccess(list: List<Bank>) {
                    successResponse.postValue(list)
                }

                override fun onFailed(msg: String) {
                    failedResponse.postValue(msg)
                }
            })
        }
    }

    fun post(bank: Bank) {
        ///launch the coroutine scope
        scope.launch {
            ApiCall.execute(bank , object : ApiCallback {
                override fun onSuccess(list: List<Bank>) {
                    successResponse.postValue(list)
                }

                override fun onFailed(msg: String) {
                    failedResponse.postValue(msg)
                }
            })
        }
    }

}