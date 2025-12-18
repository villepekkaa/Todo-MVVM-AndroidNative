package com.example.todo_mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_mvvm.model.TodosApi
import com.example.todo_mvvm.model.Todo
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    val todos = mutableListOf<Todo>()
    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL",e.message.toString())
            }
        }
    }
}
