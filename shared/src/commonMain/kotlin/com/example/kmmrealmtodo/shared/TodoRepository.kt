package com.example.kmmrealmtodo.shared

import io.realm.Cancellable
import io.realm.Realm
import io.realm.RealmConfiguration

class TodoRepository {
    val realm: Realm by lazy {
        val configuration = RealmConfiguration.Builder()
            .schema(Entities())
            .build()

        Realm.open(configuration)
    }

    fun addTodo(title: String): Todo {
        realm.beginTransaction()
        val persistedTodo = realm.create(Todo::class).apply {
            this.title = title
        }
        realm.commitTransaction()
        return persistedTodo
    }

    fun deleteTodo(todo: Todo) {
        realm.beginTransaction()
        Realm.delete(todo)
        realm.commitTransaction()
    }

    fun todos(): List<Todo> {
        return realm.objects(Todo::class)
    }

    fun listen(block: () -> Unit): Cancellable {
        return realm.objects(Todo::class).observe { block() }
    }

}