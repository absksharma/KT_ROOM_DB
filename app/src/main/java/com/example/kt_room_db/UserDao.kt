package com.example.kt_room_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Insert
    fun insertAll(list: List<User>)

    @Delete
    fun delete(user: User)

    @Query("SELECT  * FROM User")
    fun getAll(): List<User>

//    @Query("SELECT * FROM User Where age >= age")
//    fun userWithAge(age: Int): List<User>


}
