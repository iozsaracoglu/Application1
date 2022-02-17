package com.ilker.application1

import android.database.Cursor
import android.util.Log
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import com.example.android.marsrealestate.network.MarsApi


class SecondViewModel : ViewModel() {
    lateinit var testCnt: Number
    lateinit var myActivity: MainActivity
    lateinit var urlResponse: String

    init {
    }

    fun setActivity(activityIn: MainActivity) {
        myActivity = activityIn
    }

    fun setCnt() {
        var resultSet: Cursor = myActivity.getDb().rawQuery("select * from TestTable", null)
        testCnt = resultSet.count
    }

    fun addCnt() {
        myActivity.getDb().execSQL("insert into TestTable (Val1,Val2) values ('testvalue1', 31) ")
        setCnt()
    }

    fun executeURL(urlStr: String, getStr: String ) {
        Log.i("ilkerDbg", "in the url call")

        urlResponse = TestApi.retrofitService.getProperties().toString()
        Log.i("ilkerDbg", urlResponse)

        TestApi.retrofitService.getProperties().enqueue(object :Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i("ilkerDbg", "call Succeeded")
                urlResponse = response.body().toString()
                Log.i("ilkerDbg", urlResponse)
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.i("ilkerDbg", "call Failed")
                urlResponse = t.message.toString()
            }
        })



    }
}