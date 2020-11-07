package com.jk.finahub.callback

import com.jk.finahub.Bank

interface ApiCallback {
    fun onSuccess(list : List<Bank>)
    fun onFailed(msg: String)
}