package com.example.tvshowsappassessment.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowsappassessment.data.models.DummyData
import com.example.tvshowsappassessment.data.models.ShowModel
import com.example.tvshowsappassessment.ui.navigation.Routes

var selectedIndex by mutableStateOf(-1)

@Composable
fun HomeScreen(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Cyan),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Search",
                color = Color.White,
                modifier = Modifier
                    .border(2.dp, Color.White, RectangleShape)
                    .padding(5.dp)
            )
        }
        val data = DummyData()
        ShowsList(data.getData(), navController)
    }

}

@Composable
fun ShowsList(showListDummy: List<ShowModel>, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ) {
            itemsIndexed(showListDummy) { index, show ->
                ShowItem(showDetail = show, navController, index)
            }
        }

    }
}

@Composable
fun ShowItem(showDetail: ShowModel, navController: NavHostController, index: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(4.dp, Color.Cyan, RectangleShape)
            .clickable {
                Log.e("inside", "->" + index)
                selectedIndex = index
                navController.navigate(Routes.DETAILS.name)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(showDetail.path),
            contentDescription = "",
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .padding(4.dp)
        )
        Text(
            text = showDetail.title,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
    }
}
