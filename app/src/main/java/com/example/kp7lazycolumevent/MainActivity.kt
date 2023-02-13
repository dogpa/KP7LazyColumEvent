package com.example.kp7lazycolumevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kp7lazycolumevent.ui.theme.KP7LazyColumEventTheme

import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var selectPhoto:Photo? = null
        val photoList = PhotoViewModel().getPhotoList()
        setContent {
            KP7LazyColumEventTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var isClickOnePhoto  by remember { mutableStateOf(false) }
                    Column() {
                        if (isClickOnePhoto){
                            //TODO: 選擇某張照片，跳入詳細頁面
                            Column {
                                Button(onClick = { isClickOnePhoto = false}) {
                                    Text(text = "返回")
                                }
                                if (selectPhoto != null) {
                                    PhotoDetailView(photo = selectPhoto!!)
                                }
                            }
                        }else{
                            //TODO: 顯示lazyColum
                            Column {
                                IntroductionView()
                                LazyColumn() {
                                    items(photoList){
                                        PhotoView(photo = it) {
                                            isClickOnePhoto = true
                                            selectPhoto = it
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun IntroductionView() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "2022攝影集", fontSize = 40.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KP7LazyColumEventTheme {
        IntroductionView()
    }
}