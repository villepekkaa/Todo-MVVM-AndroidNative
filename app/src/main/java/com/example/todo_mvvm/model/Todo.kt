package com.example.todo_mvvm.model

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
