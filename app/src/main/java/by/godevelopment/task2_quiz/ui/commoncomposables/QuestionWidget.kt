package by.godevelopment.task2_quiz.ui.commoncomposables

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.godevelopment.task2_quiz.commons.TAG
import by.godevelopment.task2_quiz.data.models.QuestionModel
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme

@Composable
fun QuestionWidget(
    questionModel: QuestionModel,
    modifier: Modifier = Modifier,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .selectableGroup()
    ) {
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.h6,
            text = questionModel.question
        )

        questionModel.answerOptions.forEach { answer ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(start = 8.dp)
                    .selectable(
                        selected = (answer == selectedOption),
                        onClick = { onOptionSelected(answer) }
                    )
            ) {
                RadioButton(selected = (answer == selectedOption), onClick = null)
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.body1,
                    text = answer
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionWidgetPreview() {
    Task2QuizTheme(
        content = {
            QuestionWidget(
                QuestionModel("Вы готовы, дети?", listOf("Да, капитан!", "Да!", "Нет.", "Нет, капитан", "буль-буль-буль"), "Да, капитан!"),
                selectedOption = "",
                onOptionSelected = {
                    Log.i(TAG, "QuestionWidgetPreview: onOptionSelected $it")
                }
            )
        }
    )
}
