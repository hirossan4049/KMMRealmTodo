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
import com.example.kmmrealmtodo.shared.Todo
import com.example.kmmrealmtodo.shared.TodoModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var todos: List<Todo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycleView)
        todos = TodoModel.getAllTodo().asReversed()
        viewAdapter = RecyclerAdapter(this, this, todos)
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
            viewAdapter.notifyItemInserted(0);
            recyclerView.smoothScrollToPosition(0);
//            viewAdapter.notifyItemRangeChanged(1, todos.size)
//            viewAdapter.notifyDataSetChanged()
            tf.text.clear()
        }

    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "${TodoModel.todo2title(todos.get(position))} tapped!", Toast.LENGTH_SHORT).show()
        TodoModel.deleteTodo(todos.get(position))
        viewAdapter.notifyItemRemoved(position)
    }
}
