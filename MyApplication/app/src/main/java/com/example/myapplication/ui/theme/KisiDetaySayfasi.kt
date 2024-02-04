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
import com.example.myapplication.eninty.Kisiller
import com.example.myapplication.viewmmodel.KisininDetaySayfasiViewModel


import com.example.myapplication.viewmodelfactory.KisiDetaySayfaviewmodelfactory


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)

fun KisiDetaySayfasi(GelenKisi:Kisiller) {

    val tpKisiAd = remember{ mutableStateOf("") }
    val tpKisiSoy = remember{ mutableStateOf("") }
    val tpKisiTel = remember{ mutableStateOf("") }
    val tpKisiPosta = remember{ mutableStateOf("") }

    val localFocusManager = LocalFocusManager.current

    val context = LocalContext.current
    val viewModel: KisininDetaySayfasiViewModel = viewModel(
        factory = KisiDetaySayfaviewmodelfactory(context.applicationContext as Application)
    )






    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Kişi Detay")})
        },

        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = tpKisiAd.value,
                    onValueChange = {tpKisiAd.value=it},
                    label = { Text(text = "eski İsim: ${GelenKisi.Kisi_ad}")})


                TextField(value = tpKisiSoy.value,
                    onValueChange = {tpKisiSoy.value=it},
                    label = { Text(text = "eski Soy: ${GelenKisi.Kisi_soy}")})

                TextField(value = tpKisiTel.value,
                    onValueChange = {tpKisiTel.value=it},
                    label = { Text(text = "eski Numara: ${GelenKisi.Kisi_num}")})

                TextField(value = tpKisiPosta.value,
                    onValueChange = {tpKisiPosta.value=it},
                    label = { Text(text = "Eski-postası: ${GelenKisi.Kisi_posta}")})
                Button(onClick = {
                    val kisi_Ad = tpKisiAd.value
                    val kisi_Soy =  tpKisiSoy.value
                    val kisi_Numara = tpKisiTel.value
                    val kisi_Posta = tpKisiPosta.value


                    viewModel.Gunceleme(GelenKisi.Kisi_id,kisi_Ad,kisi_Soy, kisi_Numara, kisi_Posta  )



                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(245.dp,35.dp)) {

                    Text(text = "Güncelle")

                }



            }
        }

    )
}
