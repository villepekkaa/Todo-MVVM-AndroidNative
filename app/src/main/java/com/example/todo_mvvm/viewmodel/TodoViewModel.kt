package com.example.todo_mvvm.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {
    val todos = mutableStateListOf<String>()

    init {
        todos.add("Test 1")
        todos.add("Test 2")
        todos.add("Test 3")
    }
}
