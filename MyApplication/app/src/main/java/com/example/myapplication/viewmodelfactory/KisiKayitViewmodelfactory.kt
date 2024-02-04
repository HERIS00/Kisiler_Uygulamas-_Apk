package com.example.myapplication.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmmodel.KisiKayitSayfasiViewModel


class KisiKayitViewmodelfactory(var application: Application): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KisiKayitSayfasiViewModel(application) as T
    }
}