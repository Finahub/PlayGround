package com.jk.finahub.call

import com.jk.finahub.*
import com.jk.finahub.callback.ApiCallback
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.lang.reflect.Type

object ApiCall {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory())
        .build()

    /**
     * for All Saved Banks in H2
     */
    fun getAllBanksSavedDB(apiCallback: ApiCallback){
        val url = API + ENDPOINT_ALL_DB_BANKS
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(ERRORS)
                apiCallback.onFailed(ERRORS)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)


                val type: Type = Types.newParameterizedType(
                    MutableList::class.java,
                    Bank::class.java
                )

                val adapter: JsonAdapter<List<Bank>> = moshi.adapter(type)
                val banks: List<Bank>? = adapter.fromJson(body)
                println(banks)
                banks?.let { apiCallback.onSuccess(it) }
            }
        })
    }

    /**
     * Get One Row Bank from Air Table
     */

    fun getOneBankFromAirTable(apiCallback: ApiCallback){
        val url = API + ENDPOINT_ONE_AIR_TABLE_BANK
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(ERRORS)
                apiCallback.onFailed(ERRORS)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val bankAdapter = moshi.adapter(Bank::class.java)

                val bank = bankAdapter.fromJson(body)

                println(bank)
                bank?.let { apiCallback.onSuccess(listOf(bank)) }
            }
        })
    }

    /**
     * Get All Banks from Air Table
     */
    fun getAllBanksAirTable(apiCallback: ApiCallback){
        val url = API + ENDPOINT_ALL_AIR_TABLE_BANKS
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(ERRORS)
                apiCallback.onFailed(ERRORS)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)


                val type: Type = Types.newParameterizedType(
                    MutableList::class.java,
                    Bank::class.java
                )

                val adapter: JsonAdapter<List<Bank>> = moshi.adapter(type)
                val banks: List<Bank>? = adapter.fromJson(body)
                println(banks)
                banks?.let { apiCallback.onSuccess(it) }
            }
        })
    }

    fun execute(bank: Bank, apiCallback: ApiCallback){
        val url = API + ENDPOINT_POST_BANK
        val jsonAdapter: JsonAdapter<Bank> =
            moshi.adapter<Bank>(Bank::class.java)
        val json = jsonAdapter.toJson(bank)
        val mediaTypeJson = "application/json; charset=utf-8".toMediaType()//4.0.1
        val request = Request.Builder().url(url).post(json.toRequestBody(mediaTypeJson)).build()
        val client = OkHttpClient()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            println(response.body!!.string())
        }
    }
}
