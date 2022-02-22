package com.ilker.application1

import android.database.Cursor
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class SecondViewModel : ViewModel() {
    lateinit var testCnt: Number
    lateinit var myActivity: MainActivity
    lateinit var myView: SecondFragment

    var client: OkHttpClient = OkHttpClient();
    lateinit var urlResponse: String

    init {
    }

    fun setActivity(activityIn: MainActivity) {
        myActivity = activityIn
    }

    fun setView(viewIn: SecondFragment) {
        myView = viewIn
    }

    fun setCnt() {
        var resultSet: Cursor = myActivity.getDb().rawQuery("select * from TestTable", null)
        testCnt = resultSet.count
    }

    fun addCnt() {
        myActivity.getDb().execSQL("insert into TestTable (Val1,Val2) values ('testvalue1', 31) ")
        setCnt()
    }

    fun executeHTTP(urlStr: String) {
        val request: Request = Request.Builder()
            .url(urlStr)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("ilkerDbg", "call Failed")
                urlResponse = e.message.toString()
                Log.i("ilkerDbg", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    Log.i("ilkerDbg", "call Succeeded")
                    /*for ((name, value) in response.headers) {
                        //println("$name: $value")
                        Log.i("ilkerDbg", "$name: $value")
                    }*/
                    val json = Gson().toJson(response.body!!.string())
                    urlResponse = Gson().fromJson(json, String::class.java)

                    myActivity.runOnUiThread(Runnable {
                        myView.setTextMessage(urlResponse)
                    })
                    Log.i("ilkerDbg", urlResponse)

                }
            }
        })
    }

    fun getHTTPRequest(sUrl: String): String? {
        var result: String? = null
        try {
            val url = URL(sUrl)
            val request = Request.Builder().url(url).build()
            val response = client
                .newCall(request)
                .execute()
            result = response.body?.string()
        }
        catch(err:Error) {
            Log.i("ilkerDbg", "Error when executing get request: "+err.localizedMessage)
        }
        return result
    }

}