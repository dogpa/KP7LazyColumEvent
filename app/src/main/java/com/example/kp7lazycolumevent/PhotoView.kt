package com.example.kp7lazycolumevent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kp7lazycolumevent.ui.theme.KP7LazyColumEventTheme

@Composable
fun PhotoView(photo: Photo, clickEvent:()->Unit) {
    Column(modifier =
    Modifier
        .fillMaxWidth()
        .clickable(onClick = clickEvent)
        ,) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(modifier = Modifier
                .weight(0.5f)
                .padding(start = 15.dp, end = 15.dp),
                fontSize = 25.sp,
                color = colorResource(id = R.color.black),
                text = "${photo.title}",
            )

            Column(modifier = Modifier
                .weight(0.5f)) {
                Text(text = "${photo.category}", fontSize = 20.sp)
                Text(text = "攝影日期：${photo.createdDate}", color = colorResource(id = R.color.purple_700))

            }
        }

        Column() {
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
        }
        Divider(color = colorResource(R.color.black))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    KP7LazyColumEventTheme() {
        PhotoView(Photo(R.drawable.photo_bamboo_20220103, "123", "2023-02-02", "風景",1000,"1.5",4.5)){}
    }
}