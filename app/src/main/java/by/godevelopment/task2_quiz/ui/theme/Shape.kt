package by.godevelopment.task2_quiz.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val ShapesCut = Shapes(
    small = CutCornerShape(8.dp),
    medium = CutCornerShape(4.dp),
    large = CutCornerShape(0.dp)
)