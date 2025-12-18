package com.example.todo_mvvm.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_mvvm.model.TodosApi
import com.example.todo_mvvm.model.Todo
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data class Success(val todos: List<Todo>): TodoUiState
    object Error: TodoUiState
    object Loading: TodoUiState
}

class TodoViewModel: ViewModel() {
    var todoUIState: TodoUiState by mutableStateOf(TodoUiState.Loading)
        private set

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todoUIState = TodoUiState.Success(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL",e.message.toString())
                todoUIState = TodoUiState.Error
            }
        }
    }
}
