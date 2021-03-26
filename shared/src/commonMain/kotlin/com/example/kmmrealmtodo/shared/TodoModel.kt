package com.example.kmmrealmtodo.shared

class TodoModel private constructor() {
    companion object {
        private val repository: TodoRepository by lazy { TodoRepository() }

        fun addTodo(title: String) {
            repository.addTodo(title)
        }

        fun deleteTodo(todo: Todo) {
            repository.deleteTodo(todo)
        }

        fun getAllTodo(): List<Todo> {
           return repository.todos()
        }

        fun todo2title(todo: Todo): String {
            return todo.title
        }
    }
}