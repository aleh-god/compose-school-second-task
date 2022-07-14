package by.godevelopment.task2_quiz.ui.screens

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.godevelopment.task2_quiz.R
import by.godevelopment.task2_quiz.commons.TAG
import by.godevelopment.task2_quiz.data.models.QuestionModel
import by.godevelopment.task2_quiz.ui.commoncomposables.QuestionWidget
import by.godevelopment.task2_quiz.ui.commoncomposables.TopQuizBar
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme

@Composable
fun QuizScreen(
    title: String,
    onClickArrowBack: () -> Unit,
    onClickButtonNext: () -> Unit,
    onClickButtonPrevious: () -> Unit,
    questionModel: QuestionModel,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    showArrowBack: Boolean,
    enablePreviousButton: Boolean,
    enableNextButton: Boolean,
    textNextButton: String
) {
    Scaffold(
        topBar = {
            TopQuizBar(
                title = title,
                showArrowBack = showArrowBack,
                onClickArrowBack = onClickArrowBack
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            QuestionWidget(
                questionModel = questionModel,
                selectedOption = selectedOption,
                onOptionSelected = onOptionSelected
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Button(
                    modifier = Modifier.weight(2f),
                    enabled = enablePreviousButton,
                    onClick = onClickButtonPrevious
                ) {
                    Text(text = stringResource(R.string.btn_text_previous))
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    modifier = Modifier.weight(2f),
                    enabled = enableNextButton,
                    onClick = onClickButtonNext
                ) {
                    Text(text = textNextButton)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    Task2QuizTheme(
        content =  {
            QuizScreen(
                title = "Question #1",
                onClickArrowBack = {
                    Log.i(ContentValues.TAG, "TopAppBarPreview: onClickArrowBack")
                },
                questionModel = QuestionModel("Вы готовы, дети?", listOf("Да, капитан!", "Да!", "Нет.", "Нет, капитан", "буль-буль-буль"), "Да, капитан!"),
                selectedOption = "",
                onOptionSelected = {
                    Log.i(TAG, "QuestionWidgetPreview: onOptionSelected $it")
                },
                onClickButtonPrevious = {
                    Log.i(ContentValues.TAG, "TopAppBarPreview: onClickButtonPrevious")
                },
                onClickButtonNext = {
                    Log.i(ContentValues.TAG, "TopAppBarPreview: onClickButtonNext")
                },
                showArrowBack = true,
                enableNextButton = true,
                enablePreviousButton = true,
                textNextButton = stringResource(R.string.btn_text_next)
            )
        }
    )
}