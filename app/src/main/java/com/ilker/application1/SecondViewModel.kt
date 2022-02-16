package com.ilker.application1

import android.database.Cursor
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    lateinit var testCnt: Number
    lateinit var myActivity: MainActivity

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
}