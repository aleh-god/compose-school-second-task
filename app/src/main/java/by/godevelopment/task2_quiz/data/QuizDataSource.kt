package by.godevelopment.task2_quiz.data

import by.godevelopment.task2_quiz.data.models.QuestionModel

object QuizDataSource {
    val quizData: List<QuestionModel> = listOf(
        QuestionModel("Are you ready, kids?", listOf("Yes, captain!", "Yes!", "No.", "No, captain", "boo-boo-boo"), "Yes, captain!" ),
        QuestionModel("Whooooooooo... Who lives at the bottom of the ocean?", listOf("Fish", "SpongeBob SquarePants!", "Diver", "No one lives", "Terror from the Deep"), "SpongeBob SquarePants!"),
        QuestionModel("Yellow Sponge, No Flaw Baby?", listOf("Flawed", "Not Baby", "SpongeBob SquarePants!", "Blue Sponge", "Yellow Submarine"), "SpongeBob SquarePants!"),
        QuestionModel("Who wins always and everywhere?", listOf("Godzilla", "Rambo", "Captain America", "SpongeBob SquarePants!", "Purple from Power Rangers"), "SpongeBob SquarePants!") ,
        QuestionModel("Who's as agile as a fish out of water?", listOf("Another fish", "Aquaman", "Depth", "Bowl filled with concrete", "SpongeBob SquarePants!"), "SpongeBob SquarePants!")
    )
}