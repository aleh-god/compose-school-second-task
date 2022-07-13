package by.godevelopment.task2_quiz.ui.viewmodels

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import by.godevelopment.task2_quiz.R
import by.godevelopment.task2_quiz.commons.EMPTY_STRING
import by.godevelopment.task2_quiz.commons.TAG
import by.godevelopment.task2_quiz.data.QuizDataSource
import by.godevelopment.task2_quiz.data.models.QuestionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val quizDataSource: QuizDataSource
) : ViewModel() {

    private val selectedOptions: MutableMap<Int, String> = mutableMapOf()

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(
        UiState(
            showArrowBack = false,
            enablePreviousButton = false,
            enableNextButton = true,
            currentQuestionIndex = 0,
            questionModel = quizDataSource.quizData[0],
            textNextButton = R.string.btn_text_next
        )
    )
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun onClickArrowBack() {
        onClickButtonPrevious()
    }

    fun onOptionSelected(result: String) {
        selectedOptions[_uiState.value.currentQuestionIndex] = result
        _uiState.update {
            it.copy(
                selectedOption = result,
                enableNextButton =
                if (it.currentQuestionIndex == quizDataSource.quizData.lastIndex)
                    checkHaveAllAnswers()
                else true
            )
        }
    }

    fun onClickButtonPrevious() {
        _uiState.update {
            val newIndex =
                if (it.currentQuestionIndex == 0) 0
                else { it.currentQuestionIndex - 1 }
            changeUiState(newIndex)
        }
    }

    fun onClickButtonNext() {
        if (uiState.value.currentQuestionIndex == quizDataSource.quizData.lastIndex) {
            if (checkHaveAllAnswers()) {
                runResultScreen()
                return
            }
        } else {
            _uiState.update { changeUiState(it.currentQuestionIndex + 1) }
        }
    }

    private fun runResultScreen() {
        Log.i(TAG, "runResultScreen: invoke")
    }

    private fun changeUiState(newIndex: Int): UiState = uiState.value.copy(
        currentQuestionIndex = newIndex,
        questionModel = quizDataSource.quizData[newIndex],
        selectedOption = selectedOptions[newIndex] ?: EMPTY_STRING,
        enablePreviousButton = newIndex != 0,
        showArrowBack = newIndex != 0,
        textNextButton =
        if (newIndex == quizDataSource.quizData.lastIndex) R.string.btn_text_done
        else R.string.btn_text_next,
        enableNextButton =
        if (newIndex == quizDataSource.quizData.lastIndex) checkHaveAllAnswers()
        else true
    )

    private fun checkHaveAllAnswers(): Boolean {
        val countQuestions = quizDataSource.quizData.size
        val countCurrentAnswers = selectedOptions.size
        Log.i(TAG, "checkHaveAllAnswers: $countQuestions = $countCurrentAnswers")
        return countCurrentAnswers == countQuestions
    }

    data class UiState(
        val currentQuestionIndex: Int,
        val showArrowBack: Boolean,
        val enablePreviousButton: Boolean,
        val enableNextButton: Boolean,
        @StringRes
        val textNextButton: Int,
        val questionModel: QuestionModel,
        val selectedOption: String = EMPTY_STRING
    )
}