package by.godevelopment.task2_quiz.data

import by.godevelopment.task2_quiz.data.models.QuestionModel

object QuizDataSource {
    val quizData: List<QuestionModel> = listOf(
        QuestionModel("Вы готовы, дети?", listOf("Да, капитан!", "Да!", "Нет.", "Нет, капитан", "буль-буль-буль"), "Да, капитан!"),
        QuestionModel("Ктоооооооо... Кто проживает на дне океана?", listOf("Рыбки", "Губка Боб Квадратные Штаны!", "Водолаз", "Никто не проживает", "Terror from the Deep"), "Губка Боб Квадратные Штаны!"),
        QuestionModel("Жёлтая губка, малыш без изъяна?", listOf("С изъяном", "Не малышь", "Губка Боб Квадратные Штаны!", "Синяя губка", "Жёлтая подводная лодка"), "Губка Боб Квадратные Штаны!"),
        QuestionModel("Кто побеждает всегда и везде?", listOf("Годзилла", "Рэмбо", "Капитан Америка", "Губка Боб Квадратные Штаны!", "Фиолетовый из Повер Рэнджерс"), "Губка Боб Квадратные Штаны!"),
        QuestionModel("Кто также ловок, как рыба в воде?", listOf("Другая рыба", "Аквамен", "Глубина", "Тазик залитый бетоном", "Губка Боб Квадратные Штаны!"), "Губка Боб Квадратные Штаны!")
    )
}