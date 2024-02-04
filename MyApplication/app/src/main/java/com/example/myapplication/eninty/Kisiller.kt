package com.example.myapplication.eninty


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Kisiller")
data class Kisiller(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Kisi_id") @NotNull var Kisi_id:Int,
    @ColumnInfo(name = "Kisi_ad") @NotNull var Kisi_ad:String,
    @ColumnInfo(name = "Kisi_soy") @NotNull var Kisi_soy: String,
    @ColumnInfo(name = "Kisi_num") @NotNull var Kisi_num: String,
    @ColumnInfo(name = "Kisi_posta") @NotNull var Kisi_posta: String )
{

}

