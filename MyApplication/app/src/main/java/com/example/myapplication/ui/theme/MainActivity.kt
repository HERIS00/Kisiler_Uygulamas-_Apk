package com.example.myapplication.ui.theme
/**Yapılcaklar
//MVVM mimarisi yapıldı
//Room eklendi
 Kayıt sistemi tamam
 tasarım yapım aşamasında
 fierbase realtime database yapılmadı
 retrofit kütüpahnesi yapılmadı

*/
import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.R
import com.example.myapplication.eklentiler.MyApplicationTheme
import com.example.myapplication.eninty.Kisiller
import com.example.myapplication.viewmmodel.KisiAnaSayafasiViewModel
import com.example.myapplication.viewmodelfactory.AnasayfaViewmodelfactory
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SayfaGecis()
                }
            }
        }
    }
}
@Composable
fun SayfaGecis(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anaSayfa"   ){
        composable("anaSayfa"){
            Anasayfa(navController = navController)
        }
        composable("KisikayıtSayfa"){
            KisiKayitSayfasi( )
        }
        composable("KisidetaySayfa/{kisi}", arguments = listOf(
            navArgument("kisi"){type = NavType.StringType}
        )){
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json,Kisiller::class.java)
            KisiDetaySayfasi(GelenKisi = nesne )
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Anasayfa(navController: NavController) {

    val aramaYapiliyomu = remember { mutableStateOf(false) }
    val tp = remember { mutableStateOf("") }
    val context = LocalContext.current
    val viewModel: KisiAnaSayafasiViewModel = viewModel(
        factory = AnasayfaViewmodelfactory(context.applicationContext as Application)
    )
    val KisilerListesi = viewModel.KisilerListesi.observeAsState(listOf())

LaunchedEffect(key1 = true){
    viewModel.KisiYukle()
}



    Scaffold(
        topBar = {



            TopAppBar(
                title = {
                    if (aramaYapiliyomu.value) {
                        TextField(
                            value = tp.value,
                            onValueChange = {
                                tp.value = it
                                viewModel.ara(it)
                            },
                            label = { Text(text = "Ara...") },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = Color.Black,
                                unfocusedLabelColor = Color.Black,

                                )

                        )
                    } else {
                        Text(text = "Kişiler")
                    }


                },
                actions = {
                    if(aramaYapiliyomu.value) {
                        IconButton(onClick = {
                            aramaYapiliyomu.value = false
                            tp.value = ""

                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.kapat_resim),
                                contentDescription = "",
                                tint = Color.Red
                            )//magenta ne bilmiyom deniyek =)
                        }



                    }
                    else{
                        IconButton(onClick = {
                            aramaYapiliyomu.value  =true

                        }) {
                            Icon(painter = painterResource(id = R.drawable.arama_resim), contentDescription = "",
                                tint = Color.Red)//magenta ne bilmiyom deniyek =)
                        }

                    }
                }
            )
        },

        content = {
            LazyColumn{
                items(count = KisilerListesi.value!!.count(), itemContent = {
                    val kisi = KisilerListesi.value!![it]
                    Card (modifier = Modifier
                        .padding(all = 40.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()){
                        Row (modifier =Modifier.clickable {
                            val kisiJson = Gson().toJson(kisi)
                            navController.navigate("KisidetaySayfa/${kisiJson}")
                        }){
                            Row (modifier = Modifier
                                .padding(all = 15.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly){
                                Text(text = "${kisi.Kisi_ad} - ${kisi.Kisi_soy}")

                                IconButton(onClick = {
                                    viewModel.sil(kisi.Kisi_id)

                                }) {
                                    Icon(painter = painterResource(id = R.drawable.sil_resim), contentDescription = "",
                                        tint = Color.Blue)//magenta ne bilmiyom deniyek =)
                                }

                            }
                        }
                    }

                })
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("KisikayıtSayfa")
                }, containerColor = Color.Blue,
                content = {
                    Icon(painter = painterResource(id = R.drawable.ekle_resim), contentDescription = "",
                        tint = Color.Magenta)//magenta ne bilmiyom deniyek =)

                }

            )


        }

    )




}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    MyApplicationTheme()
    {

    }
}