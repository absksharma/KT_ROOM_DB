package com.example.kt_room_db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "User.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        save.setOnClickListener {
            db.userDao().insert(User("abhishek", "78451234", "dbhauisdjkba", 20))
        }
        deleteData.setOnClickListener {
            val list: List<User> = db.userDao().getAll()
            if (list.isNotEmpty()) {
                with(list[0]) {
                    textView.text = name
                    textView2.text = age.toString()
                    textView3.text = address
                    textView4.text = number
                }
            }
        }
    }
}