package com.example.kmmrealmtodo.androidApp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kmmrealmtodo.shared.Greeting
import com.example.kmmrealmtodo.shared.TodoModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val tv: TextView = findViewById(R.id.text_view)
        recyclerView = findViewById(R.id.recycleView)

        viewAdapter = RecyclerAdapter(this, this, TodoModel.getAllTodo().reversed())
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val tf: EditText = findViewById(R.id.editText)
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            TodoModel.addTodo(tf.text.toString())
            viewAdapter.notifyDataSetChanged()
            tf.text.clear()
//            tf.clearFocus()
        }
//        tv.text = greet()

//        val todoRepository = TodoModel
//
        Log.d("test", "$TodoModel.getAllTodo()")
//        tv.text = "$todo.title"
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "$position tapped!", Toast.LENGTH_SHORT).show()
    }
}
