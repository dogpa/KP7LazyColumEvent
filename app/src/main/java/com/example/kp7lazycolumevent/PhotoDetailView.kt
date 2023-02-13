package com.example.kp7lazycolumevent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kp7lazycolumevent.ui.theme.KP7LazyColumEventTheme

@Composable
fun PhotoDetailView (photo:Photo) {
    Column() {
        Column (
            modifier = Modifier.fillMaxWidth()
                .height(50.dp),
            verticalArrangement = Arrangement.Center, 
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Text(text = photo.title, textAlign = TextAlign.Center, fontSize = 30.sp)
        }

        Row(Modifier.padding(start = 5.dp, end = 5.dp, bottom = 25.dp)) {
            Image(
                painter = painterResource(id = photo.resource),
                contentDescription = "android_developers",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix()),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "類別：${photo.category}")
            Text(text = "攝影日期：${photo.createdDate}")
            Text(text = "光圈：f${photo.aperture}")
            Text(text = "ISO：${photo.ISO}")
            Text(text = "曝光：${photo.exposureTime} 秒")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3 () {
    KP7LazyColumEventTheme {
        PhotoDetailView(Photo(R.drawable.photo_star_track_20220101,"石門山星軌","2022-01-01","星空",1000,"2.0",3.4))
    }
}