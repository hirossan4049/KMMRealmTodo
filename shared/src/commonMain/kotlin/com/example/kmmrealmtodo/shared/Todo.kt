package com.example.kmmrealmtodo.shared

import io.realm.RealmModule
import io.realm.RealmObject

class Todo: RealmObject {
    var title: String = "no title"
}

@RealmModule(Todo::class)
class Entities