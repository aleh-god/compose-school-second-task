package by.godevelopment.task2_quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.godevelopment.task2_quiz.data.QuizDataSource
import by.godevelopment.task2_quiz.ui.screens.QuizScreen
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme
import by.godevelopment.task2_quiz.ui.viewmodels.MainViewModel
import by.godevelopment.task2_quiz.ui.viewmodels.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(QuizDataSource) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    setContent {
                        Task2QuizTheme {
                            QuizScreen(
                                title = getString(R.string.screen_title_question) + (uiState.currentQuestionIndex + 1).toString(),
                                questionModel = uiState.questionModel,
                                selectedOption = uiState.selectedOption,
                                showArrowBack = uiState.showArrowBack,
                                textNextButton = getString(uiState.textNextButton),
                                enablePreviousButton = uiState.enablePreviousButton,
                                enableNextButton = uiState.enableNextButton,

                                onClickArrowBack = viewModel::onClickArrowBack,
                                onOptionSelected = viewModel::onOptionSelected,
                                onClickButtonPrevious = viewModel::onClickButtonPrevious,
                                onClickButtonNext = viewModel::onClickButtonNext
                            )
                        }
                    }
                }
            }
        }
    }
}

