package by.godevelopment.task2_quiz.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme

@Composable
fun QuizScreen(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Task2QuizTheme {
        QuizScreen("task 2 quiz")
    }
}