package com.example.kt_room_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // TO create a Table in Room
data class User(
    val name: String,
    val number: String,
    val address: String,
    val age: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)
