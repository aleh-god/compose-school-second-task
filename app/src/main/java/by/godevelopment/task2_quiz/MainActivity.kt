package by.godevelopment.task2_quiz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import by.godevelopment.task2_quiz.data.QuizDataSource
import by.godevelopment.task2_quiz.ui.models.AppScreen
import by.godevelopment.task2_quiz.ui.screens.QuizScreen
import by.godevelopment.task2_quiz.ui.screens.ResultScreen
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme
import by.godevelopment.task2_quiz.ui.viewmodels.MainViewModel
import by.godevelopment.task2_quiz.ui.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(QuizDataSource) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (viewModel.uiState.value.currentQuestionIndex == 0) finish()
                else viewModel.onClickButtonPrevious()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

        viewModel.destination.observe(this) { screen ->
            setContent {
                when (screen) {
                    AppScreen.Quiz -> {
                        val uiState = viewModel.uiState.collectAsState()
                        Task2QuizTheme(
                            themeNumber = uiState.value.currentQuestionIndex,
                            content = {
                                QuizScreen(
                                    title = getString(R.string.screen_title_question) + (uiState.value.currentQuestionIndex + 1).toString(),
                                    questionModel = uiState.value.questionModel,
                                    selectedOption = uiState.value.selectedOption,
                                    showArrowBack = uiState.value.showArrowBack,
                                    textNextButton = getString(uiState.value.textNextButton),
                                    enablePreviousButton = uiState.value.enablePreviousButton,
                                    enableNextButton = uiState.value.enableNextButton,

                                    onClickArrowBack = viewModel::onClickArrowBack,
                                    onOptionSelected = viewModel::onOptionSelected,
                                    onClickButtonPrevious = viewModel::onClickButtonPrevious,
                                    onClickButtonNext = viewModel::onClickButtonNext
                                )
                            }
                        )
                    }
                    AppScreen.Result -> {
                        Task2QuizTheme(
                            themeNumber = 0,
                            content = {
                                ResultScreen(
                                    resultText = generateTextReport(viewModel.generateResult()),
                                    onClickArrowBack = { viewModel.restartQuizScreen() },
                                    onClickEmail = { sendResultByEmail(
                                        generateTextReport(viewModel.generateResult())
                                    )
                                    },
                                    onClickExitToApp = { finish() }
                                )
                            }
                        )
                    }
                    null -> throw IllegalArgumentException()
                }
            }
        }
    }

    private fun generateTextReport(result: Pair<Int, Int>): String =
        getString(R.string.report_messages, result.first, result.second)

    private fun sendResultByEmail(subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
