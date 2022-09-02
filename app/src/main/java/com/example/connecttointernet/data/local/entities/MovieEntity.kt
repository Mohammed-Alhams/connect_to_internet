package com.example.connecttointernet.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey val id : Long,
    val title: String,
    val vote: Double,
    val imgPath: String
)
