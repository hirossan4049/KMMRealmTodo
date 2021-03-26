package com.example.kmmrealmtodo.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.kmmrealmtodo.shared.Greeting
import android.widget.TextView
import com.example.kmmrealmtodo.shared.TodoModel
import com.example.kmmrealmtodo.shared.TodoRepository

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        val btn: Button  = findViewById(R.id.button)
        btn.setOnClickListener {
            TodoModel.addTodo("test1")
            var text = ""
            for (i in TodoModel.getAllTodo()){
                text += TodoModel.todo2title(i)
            }
            tv.text = text
        }
//        tv.text = greet()

//        val todoRepository = TodoModel
//
        val todos =

        Log.d("test","$TodoModel.getAllTodo()")
//        tv.text = "$todo.title"
    }
}
