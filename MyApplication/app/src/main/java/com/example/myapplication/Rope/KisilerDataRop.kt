package com.example.myapplication.Rope


import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.eninty.Kisiller
import com.example.myapplication.room.VeriTabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class KisilerDataRop(var application: Application) {

    var KisilerListesi = MutableLiveData<List<Kisiller>>()
    var vt:VeriTabani
    init {
        vt= VeriTabani.verirtabaniEris(application)!!
        KisilerListesi = MutableLiveData()

    }

    fun KisileriGetir():MutableLiveData<List<Kisiller>>{
        return KisilerListesi
    }



    fun TumKisilerAl(){
       val job:Job = CoroutineScope(Dispatchers.Main).launch {
           KisilerListesi.value=vt.KisillerDao().tumKisiller()
       }
    }
    fun KisiAra( ARANANsahis:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {

            KisilerListesi.value = vt.KisillerDao().kisiArama(ARANANsahis)
        }


    }
    fun KisiEkleme(kisi_Ad:String,kisi_Soy:String,kisi_Tel:String,kisi_Posta:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
    val yeniKisi= Kisiller(0,kisi_Ad,kisi_Soy,kisi_Tel,kisi_Posta)
            vt.KisillerDao().kisiEkle(yeniKisi)
        }

    }
    fun KisiGünceleme(kisi_id:Int,kisi_Ad:String,kisi_Soy:String,kisi_Tel:String,kisi_Posta:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val GuncelleKisi= Kisiller(kisi_id,kisi_Ad,kisi_Soy,kisi_Tel,kisi_Posta)
            vt.KisillerDao().KisiGuncelle(GuncelleKisi)
        }
    }
    fun KisiSil(kisi_id:Int){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi= Kisiller(kisi_id,"","","","")
            vt.KisillerDao().kisiSil(silinenKisi)
        TumKisilerAl()
        }


    }
}
