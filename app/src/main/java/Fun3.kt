fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    println("Задача 1 - Обрабратка null email(С null)")
    formatUserInfo("Иван", 25, null)
    println("Задача 1 - Обрабратка null email(Без null)")
    formatUserInfo("Марина", 30, "marina@ya.ru")

    println("Задача  - Оценки")
    val grades = listOf(5, 4, 3, 2, 1, 6)
    gradeDescriptions(grades)

    println("Задача 3 - Животные")
    val animals = listOf(
        Lion(),
        Monkey()
    )
    for (animal in animals) {
        animal.makeSound()
    }

    println("Задача 4 - Фигуры")
    val circle = Circle(5.0)
    val rectangle = Rectangle(4.0, 6.0)
    val triangle = Triangle(3.0, 4.0)

    val shapes: List<Shape> = listOf(circle, rectangle, triangle)

    for (shape in shapes) {
        if (shape is Drawable) {
            shape.draw()
        }
        println("Площадь: ${shape.area()}")
        println()
    }
    println("Задача 5 - Список пользователей")
    val users = listOf(
        User("Анна", 25),
        User("Борис", 17),
        User("Катя", 19),
        User("Денис", 16)
    )
    processUsers(users)
}

fun formatUserInfo(name: String, age: Int, email: String?) {
    val result = email?.let {
        "Имя: $name, Возраст: $age, Email: $it"
    } ?: run {
        "Имя: $name, Возраст: $age, Email: не указан"
    }
    println(result)
}

fun gradeDescriptions(grades: List<Int>): List<String> {
    val descriptions = grades.map { grade ->
        when (grade) {
            5 -> "Отлично"
            4 -> "Хорошо"
            3 -> "Удовлетворительно"
            2 -> "Неудовлетворительно"
            1 -> "Плохо"
            else -> "Некорректная оценка"
        }
    }
    println("Результаты оценок: $descriptions")
    return descriptions
}
