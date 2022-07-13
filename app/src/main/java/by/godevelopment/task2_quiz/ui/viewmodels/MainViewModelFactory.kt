package by.godevelopment.task2_quiz.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.godevelopment.task2_quiz.data.QuizDataSource

class MainViewModelFactory(private val quizDataSource: QuizDataSource) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(quizDataSource) as T
        }
        throw IllegalArgumentException("Unknown model class")
    }
}
