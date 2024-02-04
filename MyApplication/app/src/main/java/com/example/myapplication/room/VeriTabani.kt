package com.example.myapplication.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.eninty.Kisiller

@Database(entities = [Kisiller::class], version = 1)
abstract class VeriTabani:RoomDatabase() {
    abstract fun KisillerDao():KisillerDao

    companion object{
        var INSTANCE:VeriTabani? = null

        fun verirtabaniEris(context:Context):VeriTabani?{
            if(INSTANCE==null){
                synchronized(VeriTabani::class){
                    INSTANCE=Room.databaseBuilder(
                        context.applicationContext
                        ,VeriTabani::class.java
                        ,"rehper04.sqlite").createFromAsset("rehper04.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}