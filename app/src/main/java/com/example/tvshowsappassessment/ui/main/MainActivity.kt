package com.example.tvshowsappassessment.ui.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tvshowsappassessment.data.ShowApi
import com.example.tvshowsappassessment.data.models.ShowModel
import com.example.tvshowsappassessment.retrofit.RetrofitModule
import com.example.tvshowsappassessment.ui.navigation.ShowsNavigation
import com.example.tvshowsappassessment.ui.theme.TVShowsAppAssessmentTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TVShowsAppAssessmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().background(Color.White)
                ) {
                    //getShowList()
                    ShowsNavigation()

                }
            }
        }
    }

}

var showCustomDialog by mutableStateOf(false)
val list = listOf<ShowModel>()


/*
* Unable to create account themoviedb. All implementation for API calling is done. But fetching hardcode data
* */
fun getShowList() {
    val quotesApi = RetrofitModule.getInstance().create(ShowApi::class.java)

    GlobalScope.launch {
        val result = quotesApi.getShows()
        if (result != null) {

            for (i in 0..result.body()!!.size - 1) {
                list.toMutableList().add(result.body()!!.get(i))
            }
            showCustomDialog = true
        }
    }
}

fun searchShows() {
    val quotesApi = RetrofitModule.getInstance().create(ShowApi::class.java)

    GlobalScope.launch {
        val result = quotesApi.getSearchedShows()
        if (result != null) {

            for (i in 0..result.body()!!.size - 1) {
                list.toMutableList().add(result.body()!!.get(i))
            }
            showCustomDialog = true
        }
    }
}

fun getSimilarShows() {
    val quotesApi = RetrofitModule.getInstance().create(ShowApi::class.java)

    GlobalScope.launch {
        val result = quotesApi.getSimilarShows()
        if (result != null) {

            for (i in 0..result.body()!!.size - 1) {
                list.toMutableList().add(result.body()!!.get(i))
            }
            showCustomDialog = true
        }
    }
}