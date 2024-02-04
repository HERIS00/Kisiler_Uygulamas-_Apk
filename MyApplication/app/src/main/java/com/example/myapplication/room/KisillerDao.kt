package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.eninty.Kisiller
import androidx.room.*

@Dao
interface KisillerDao {

    @Query("SELECT * FROM kisiller")
    suspend fun tumKisiller():List<Kisiller>


    @Insert
    suspend fun kisiEkle(kisiller: Kisiller)

    @Update
    suspend fun  KisiGuncelle(kisiller: Kisiller)

    @Delete
    suspend fun kisiSil(kisiller: Kisiller)



    @Query("SELECT * FROM kisiller WHERE kisi_ad like '%' || :aramaKelimesi || '%' ")
    suspend fun kisiArama(aramaKelimesi:String):List<Kisiller>

   /** Ek kodlar bellki ilerde lazım olur
    *
    *  @Query("SELECT * FROM kisiller ORDER BY RANDOM()LİMİT 1")
    *     suspend fun rastgeleKisiGetir():List<Kisiller>
    *
    *@Query("SELECT * FROM kisiller WHERE kisi_id =:kisi_id")
    *suspend fun KisiGetir(kisi_id:Int):Kisiller

    *@Query("SELECT * FROM kisiller WHERE kisi_ad =:kisi_ad")
   * suspend fun KisiKontrol(kisi_ad:String):Int*/








}