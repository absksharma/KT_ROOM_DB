package com.example.kt_room_db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "User.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        save.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                db.userDao().insert(User("abhishek", "78451234", "dbhauisdjkba", 20))

            }
        }
        deleteData.setOnClickListener {
            runBlocking {
                val list = GlobalScope.async(Dispatchers.IO) { db.userDao().getAll() }
                if (list.await().isNotEmpty()) {
                    with(list.await()[0]) {
                        textView.text = name
                        textView2.text = age.toString()
                        textView3.text = address
                        textView4.text = number
                    }
                }
            }
        }
    }
}
