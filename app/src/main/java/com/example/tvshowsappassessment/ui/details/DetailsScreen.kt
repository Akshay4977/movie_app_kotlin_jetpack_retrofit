package com.example.tvshowsappassessment.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowsappassessment.data.models.DummyData
import com.example.tvshowsappassessment.data.models.ShowModel
import com.example.tvshowsappassessment.ui.home.selectedIndex

@Composable
fun DetailsScreens(onNavigateToRecordScreen: () -> Unit) {

    val data = DummyData()

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(10.dp)

        ) {

            Image(
                painter = rememberAsyncImagePainter(data.getData().get(selectedIndex).path),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(4.dp)
            )
            Text(
                text = "Description",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
            )
            Text(
                modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp),
                text = data.getData().get(selectedIndex).overview,
                color = Color.Gray
            )
            Text(
                modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp),
                text = "Similar Shows",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalScrollScreen(data.showRelatedListDummy)
        }
    }
}


@Composable
fun HorizontalScrollScreen(showListDummy: List<ShowModel>) {

    Box(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                itemsIndexed(showListDummy) { index, item ->
                    Card(
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp)
                            .padding(5.dp)
                            .wrapContentSize(align = Alignment.Center)
                            .border(2.dp, Color.Cyan, RectangleShape)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(item.thumbnail),
                            contentDescription = "",
                        )
                    }
                }
            }
        }
    }
}
