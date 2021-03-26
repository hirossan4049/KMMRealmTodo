package com.example.kmmrealmtodo.shared

class TodoModel private constructor() {
    companion object {
        private val repository: TodoRepository by lazy { TodoRepository() }

        fun addTodo(title: String) {
            repository.addTodo(title)
        }

        fun getAllTodo(): List<Todo> {
           return repository.todos()
        }

        fun todo2title(todo: Todo): String {
            return todo.title
        }
    }
}