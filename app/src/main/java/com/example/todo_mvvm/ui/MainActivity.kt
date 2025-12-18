package com.example.todo_mvvm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo_mvvm.model.Todo
import com.example.todo_mvvm.ui.theme.TodoMVVMTheme
import com.example.todo_mvvm.viewmodel.TodoUiState
import com.example.todo_mvvm.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoMVVMTheme {
                // kommentoitu tämä scaffold, jotta on vain yksi scaffold käytössä
               // Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoApp(
                      //  modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(modifier: Modifier = Modifier, todoViewModel: TodoViewModel =
    viewModel()) {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text ("Todos") }
        ) }
    ) { innerPadding ->
        TodoScreen(
            modifier = modifier.padding(innerPadding),
            uiState = todoViewModel.todoUIState
        )
    }
}
@Composable
fun TodoScreen(modifier: Modifier = Modifier, uiState: TodoUiState) {
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen()
        is TodoUiState.Success -> TodoList(modifier, todos = uiState.todos)
        is TodoUiState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen() {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen() {
    Text(text = "Error retrieving data from API.")
}


@Composable
fun TodoList(modifier: Modifier = Modifier, todos: List<Todo>) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp)
    ) { items(todos) { todo ->
        Text(
            text = todo.title,
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        )
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
    }
}