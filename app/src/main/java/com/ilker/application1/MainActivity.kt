package com.ilker.application1

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var myDb: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDb = openOrCreateDatabase("app1", MODE_PRIVATE, null)
        myDb.execSQL("CREATE TABLE IF NOT EXISTS TestTable (Val1 VARCHAR, Val2 INTEGER);")
        var resultSet: Cursor = myDb.rawQuery("select * from TestTable", null)
        var resultCnt = resultSet.count
        Log.i("ilkerDbg", "cnt="+resultCnt)
        if (resultCnt == 0) {
            myDb.execSQL("insert into TestTable (Val1,Val2) values ('testvalue1', 19) ")
        }
        else Log.i("ilkerDbg", "rows exist already")


    }

    fun getDb(): SQLiteDatabase {
        return myDb
    }
}