package by.godevelopment.task2_quiz.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.godevelopment.task2_quiz.R
import by.godevelopment.task2_quiz.ui.theme.Task2QuizTheme

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    resultText: String,
    onClickArrowBack: () -> Unit,
    onClickEmail: () -> Unit,
    onClickExitToApp: () -> Unit
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                text = resultText
            )
            IconButton(onClick = onClickArrowBack) {
                Icon(
                    Icons.Filled.ArrowBack,
                    modifier = Modifier.size(80.dp),
                    contentDescription = stringResource(R.string.cd_icon_arrow_back)
                )
            }
            IconButton(onClick = onClickEmail) {
                Icon(
                    Icons.Outlined.Email,
                    modifier = Modifier.size(80.dp),
                    contentDescription = stringResource(R.string.cd_icon_send_email)
                )
            }
            IconButton(onClick = onClickExitToApp) {
                Icon(
                    Icons.Filled.ExitToApp,
                    modifier = Modifier.size(80.dp),
                    contentDescription = stringResource(R.string.cd_icon_exit)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    Task2QuizTheme(
        content = {
            ResultScreen(
                resultText = "Result 5/5",
                onClickArrowBack = { },
                onClickEmail = { },
                onClickExitToApp = { }
            )
        }
    )
}