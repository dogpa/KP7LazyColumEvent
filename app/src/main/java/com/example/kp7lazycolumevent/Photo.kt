package com.example.kp7lazycolumevent

data class Photo(
    val resource: Int,          // 照片
    val title: String,          // 標題
    val createdDate: String,    // 拍攝日
    val category: String,       // 照片分類
    val ISO: Int,               // ISO數值
    val exposureTime: String,   // 曝光時間
    val aperture: Double        // 光圈
)

