package com.example.myapplication.ui.theme


import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmmodel.KisiKayitSayfasiViewModel


import com.example.myapplication.viewmodelfactory.KisiKayitViewmodelfactory

@SuppressLint("UnusedMaterial3ScffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun KisiKayitSayfasi() {
    val tpKisiAd = remember{ mutableStateOf("") }
    val tpKisiSoy = remember{ mutableStateOf("") }
    val tpKisiTel = remember{ mutableStateOf("") }
    val tpKisiPosta = remember{ mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    val context = LocalContext.current
    val viewModel:KisiKayitSayfasiViewModel = viewModel(
        factory = KisiKayitViewmodelfactory(context.applicationContext as Application)
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Kişi Kayıt")})
        },

        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = tpKisiAd.value,
                    onValueChange = {tpKisiAd.value=it},
                    label = { Text(text = "İsmi")})


                TextField(value = tpKisiSoy.value,
                    onValueChange = {tpKisiSoy.value=it},
                    label = { Text(text = "Soy ismi")})

                TextField(value = tpKisiTel.value,
                    onValueChange = {tpKisiTel.value=it},
                    label = { Text(text = "Numarası")})

                TextField(value = tpKisiPosta.value,
                    onValueChange = {tpKisiPosta.value=it},
                    label = { Text(text = "E-postası")})
                Button(onClick =
                {
                    val kisi_Ad = tpKisiAd.value
                    val kisi_Soy = tpKisiSoy.value
                    val kisi_Numara = tpKisiTel.value
                    val kisi_Posta = tpKisiPosta.value
                    viewModel.Kayit(kisi_Ad,kisi_Soy,kisi_Numara,kisi_Posta)


                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(245.dp,35.dp)) {

                    Text(text = "Kaydet")

                }



            }
        }

    )
}