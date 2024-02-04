package com.example.myapplication.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmmodel.KisininDetaySayfasiViewModel


class KisiDetaySayfaviewmodelfactory(var application: Application): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KisininDetaySayfasiViewModel(application) as T
    }
}