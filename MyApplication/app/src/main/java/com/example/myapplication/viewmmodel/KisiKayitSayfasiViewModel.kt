package com.example.myapplication.viewmmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.myapplication.Rope.KisilerDataRop

class KisiKayitSayfasiViewModel(application: Application): AndroidViewModel(application) {
    var Kroto = KisilerDataRop(application)

    fun Kayit(kisi_Ad:String,kisi_Soy:String,kisi_Tel:String,kisi_Posta:String){
        Kroto.KisiEkleme(kisi_Ad,kisi_Soy,kisi_Tel,kisi_Posta)

    }
}



