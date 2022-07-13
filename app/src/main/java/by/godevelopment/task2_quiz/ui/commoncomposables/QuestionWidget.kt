package by.godevelopment.task2_quiz.ui.commoncomposables

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.godevelopment.task2_quiz.commons.EMPTY_STRING
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

    // val(selectedOption, onOptionSelected) = remember { mutableStateOf(EMPTY_STRING) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .selectableGroup()
    ) {
        Text(
            modifier = Modifier,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
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
                Text(modifier = Modifier.padding(start = 8.dp), text = answer)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionWidgetPreview() {
    Task2QuizTheme {
        QuestionWidget(
            QuestionModel("Вы готовы, дети?", listOf("Да, капитан!", "Да!", "Нет.", "Нет, капитан", "буль-буль-буль"), "Да, капитан!"),
            selectedOption = "",
            onOptionSelected = {
                Log.i(TAG, "QuestionWidgetPreview: onOptionSelected $it")
            }
        )
    }
}
