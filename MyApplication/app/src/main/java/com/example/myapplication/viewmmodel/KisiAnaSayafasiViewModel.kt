package com.example.myapplication.viewmmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Rope.KisilerDataRop
import com.example.myapplication.eninty.Kisiller


class KisiAnaSayafasiViewModel (application: Application): AndroidViewModel(application) {

        var kroto = KisilerDataRop(application)
        var KisilerListesi = MutableLiveData<List<Kisiller>>()


        init {
            KisiYukle()
            KisilerListesi =kroto.KisileriGetir()
        }
        fun KisiYukle(){
            kroto.TumKisilerAl()
        }
        fun ara (arama:String){
            kroto.KisiAra(arama)
        }
        fun sil(kisi_id:Int){
            kroto.KisiSil(kisi_id)
        }

    }
