fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    println("Задача 1")

    val celsius = 25.0
    val fahrenheit = convertTemperature(celsius, true)
    println("$celsius °C = $fahrenheit °F")

    val convertedBack = convertTemperature(fahrenheit, false)
    println("$fahrenheit °F = $convertedBack °C")

    println("Задача 2")
    val name = "Иван Петров"
    val email = "ivan.petrov@example.com"
    val phone = "+7 (123) 456-78-90"

    val contactInfo = formatContactInfo(name, email, phone)
    println(contactInfo)

    println("Задача 3")
    println("Первый вызов:")
    println(generateGreeting("Маша", "вечер", true, "С праздником!"))
    println("Второй вызов:")
    println(generateGreeting("Петя", "утро", false, "Как дела?"))
}

fun convertTemperature(temperature: Double, toFahrenheit: Boolean): Double {
    return if (toFahrenheit) {
        // Конвертация из Цельсия в Фаренгейт
        temperature * 9 / 5 + 32
    } else {
        // Конвертация из Фаренгейта в Цельсий
        (temperature - 32) * 5 / 9
    }
}

fun formatContactInfo(name: String, email: String, phone: String): String {
    return """
        |Контактная информация:
        |Имя: ${name}
        |Email: ${email}
        |Телефон: ${phone}
    """.trimMargin()
}

fun generateGreeting(
    name: String,
    timeOfDay: String = "день",
    isSpecialOccasion: Boolean = false,
    vararg messages: String
): String {
    val timeGreeting = if (timeOfDay == "утро") "Доброе утро"
    else if (timeOfDay == "день") "Добрый день"
    else if (timeOfDay == "вечер") "Добрый вечер"
    else if (timeOfDay == "ночь") "Доброй ночи"
    else "Привет"


    val nameGreeting = if (isSpecialOccasion)
        "Уважаемый(ая) $name!"
    else
        "Привет, $name!"


    val extraMessages = if (messages.isNotEmpty())
        "\n" + messages.joinToString("\n")
    else
        ""

    val result = "$timeGreeting!\n$nameGreeting$extraMessages"

    return result
}