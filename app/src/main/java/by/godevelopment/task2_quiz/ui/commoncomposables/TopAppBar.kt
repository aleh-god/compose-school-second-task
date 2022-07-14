package by.godevelopment.task2_quiz.ui.commoncomposables

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.godevelopment.task2_quiz.R
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme

@Composable
fun TopQuizBar(
    title: String,
    showArrowBack: Boolean,
    onClickArrowBack: () -> Unit
) {
    androidx.compose.material.TopAppBar {
        if (showArrowBack) {
            IconButton(
                onClick = onClickArrowBack
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.cd_arrow_back))
            }
        }
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 22.sp,
            style = MaterialTheme.typography.subtitle1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopQuizBarPreview() {
    Task2QuizTheme(
        content = {
            TopQuizBar(
                title = "Question #1",
                showArrowBack = true,
                onClickArrowBack = {
                    Log.i(TAG, "TopAppBarPreview: onClickArrowBack")
                }
            )
        }
    )
}