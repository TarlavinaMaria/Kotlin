fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    println("Задача 1")
    printUserInfo()
    println("")

    println("Задача 2")
    checkStringLength()
    println("")

    println("Задача 3")
    println("Сумма чётных чисел: ${sumEvenNumbers()}")
    println("")

    println("Задача 4")
    println("Слова длиннее 5 символов: ${filterLongWords()}")
    println("")

    println("Задача 5")
    processNames()

}

fun printUserInfo() {
    val userName: String = "Мария"
    val userAge: Int = 23
    val hasDriverLicense: Boolean = false

    println("Имя: $userName")
    println("Возраст: $userAge")
    println("Есть права: $hasDriverLicense")
}

fun checkStringLength() {
    val nullableString: String? = null
    println(nullableString?.length ?: "Строка пуста")
}

fun sumEvenNumbers(): Int {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var sum = 0
    for (number in numbers) {
        if (number % 2 == 0) {
            sum += number
        }
    }
    return sum
}

fun filterLongWords(): List<String> {
    val fruits = listOf("яблоко", "банан", "апельсин", "груша", "ананас")
    return fruits.filter { it.length > 5 }
}

fun processNames() {
    val names = listOf("Анна", null, "Борис", "Катя", null, "Денис")
    names.filterNotNull().forEach { name ->
        when {
            name.startsWith("А") -> println("Имя начинается на А: $name")
            name.startsWith("Б") -> println("Имя начинается на Б: $name")
            else -> println("Другое имя: $name")
        }
    }
}
