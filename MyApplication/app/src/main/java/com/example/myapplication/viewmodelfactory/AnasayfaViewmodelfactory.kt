package com.example.myapplication.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmmodel.KisiAnaSayafasiViewModel


class AnasayfaViewmodelfactory(var application: Application):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KisiAnaSayafasiViewModel(application) as T
    }
}