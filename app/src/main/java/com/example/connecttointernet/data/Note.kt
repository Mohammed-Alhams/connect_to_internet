package com.example.connecttointernet.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity()
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "Content") val content: String,
    val date: Date,
    val isImportant: Boolean,
    val archived: Boolean?
)
