package com.example.myapplication.viewmmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.myapplication.Rope.KisilerDataRop

class KisininDetaySayfasiViewModel(application: Application): AndroidViewModel(application) {

        var kroto = KisilerDataRop(application)
        fun Gunceleme(kisi_id:Int,kisi_Ad:String,kisi_Soy:String,kisi_Tel:String,kisi_Posta:String){
            kroto.KisiGünceleme(kisi_id,kisi_Ad,kisi_Soy,kisi_Tel,kisi_Posta)

        }
    }
