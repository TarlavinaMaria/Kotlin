fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))

    println("Задача 1 - Конвертация температуры")
    val celsius = 25.0
    val fahrenheit = convertTemperature(celsius, true)
    println("Конвертация $celsius°C в Фаренгейты: $fahrenheit°F")

    val convertedBack = convertTemperature(fahrenheit, false)
    println("Обратная конвертация $fahrenheit°F в Цельсии: $convertedBack°C")

    println("Задача 2 - Контактная информация")
    val name = "Иван Петров"
    val email = "ivan.petrov@example.com"
    val phone = "+7 (123) 456-78-90"

    val contactInfo = formatContactInfo(name, email, phone)
    println(contactInfo)

    println("Задача 3 - Приветствие")
    println("Специальное приветствие:")
    println(generateGreeting("Маша", "вечер", true, "С праздником!"))
    println("\nОбычное приветствие:")
    println(generateGreeting("Петя", "утро", false, "Как дела?"))

    println("Задача 4 - Библиотека")
    val myLibrary = mutableListOf<Map<String, Any>>()

    // Добавление книг в библиотеку
    addBookToLibrary(myLibrary, createBook("Властелин колец", "Толкин", 2000, "Фантастика"))
    addBookToLibrary(myLibrary, createBook("Гарри Поттер", "Джоан Роулинг", 2006, "Фантастика"))
    addBookToLibrary(myLibrary, createBook("Хоббит", "Толкин", 2010, "Фантастика"))

    println("Все книги: $myLibrary")
    println("Книги Толкина: ${findBooksByAuthor(myLibrary, "Толкин")}")
    println("Средний год: ${calculateAverageYear(myLibrary)}")
    println("\nОтчет:\n${generateLibraryReport(myLibrary)}")
}

/**
 * Конвертирует температуру между Цельсием и Фаренгейтом
 * @param temperature исходная температура
 * @param toFahrenheit направление конвертации (true - в Фаренгейты, false - в Цельсии)
 * @return конвертированное значение температуры
 */
fun convertTemperature(temperature: Double, toFahrenheit: Boolean): Double {
    return if (toFahrenheit) {
        // Конвертация из Цельсия в Фаренгейт
        temperature * 9 / 5 + 32
    } else {
        // Конвертация из Фаренгейта в Цельсий
        (temperature - 32) * 5 / 9
    }
}

/**
 * Форматирует контактную информацию в читаемый вид
 * @param name имя контакта
 * @param email электронная почта
 * @param phone номер телефона
 * @return отформатированная строка с контактами
 */
fun formatContactInfo(name: String, email: String, phone: String): String {
    return """
        |Контактная информация:
        |Имя: ${name}
        |Email: ${email}
        |Телефон: ${phone}
    """.trimMargin()
}

/**
 * Генерирует персонализированное приветствие
 * @param name имя для приветствия
 * @param timeOfDay время суток (утро/день/вечер/ночь)
 * @param isSpecialOccasion флаг особого случая
 * @param messages дополнительные сообщения
 * @return строка с приветствием
 */
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

/**
 * Создает объект книги в виде Map
 * @param title название книги
 * @param author автор
 * @param year год издания (по умолчанию текущий)
 * @param genre жанр (по умолчанию "не указан")
 * @return объект книги
 */
fun createBook(title: String, author: String, year: Int = 2025, genre: String = "не указан") =
    mapOf("title" to title, "author" to author, "year" to year, "genre" to genre)

/**
 * Добавляет книгу в библиотеку
 * @param library список книг (библиотека)
 * @param book книга для добавления
 */
fun addBookToLibrary(library: MutableList<Map<String, Any>>, book: Map<String, Any>) {
    library.add(book)
}

/**
 * Находит книги по указанному автору
 * @param library список книг
 * @param author автор для поиска
 * @return список книг указанного автора
 */
fun findBooksByAuthor(library: List<Map<String, Any>>, author: String) =
    library.filter { it["author"] == author }
        .joinToString("\n") { book ->
            "Название: ${book["title"]}, Год: ${book["year"]}, Жанр: ${book["genre"]}"
        }

/**
 * Вычисляет средний год издания книг в библиотеке
 * @param library список книг
 * @return средний год издания (0 если библиотека пуста)
 */
fun calculateAverageYear(library: List<Map<String, Any>>) =
    if (library.isEmpty()) 0 else library.map { it["year"] as Int }.average()

/**
 * Генерирует отчет о состоянии библиотеки
 * @param library список книг
 * @return строковый отчет
 */
fun generateLibraryReport(library: List<Map<String, Any>>): String {
    if (library.isEmpty()) return "Библиотека пуста"

    val genres = library.groupBy { it["genre"] }
        .map { "${it.key}: ${it.value.size} шт." }
        .joinToString(", ")

    return """
        Книг: ${library.size}
        Авторы: ${library.map { it["author"] }.toSet().joinToString()}
        Жанры: $genres
        Средний год: ${"%.0f".format(calculateAverageYear(library))}
    """.trimIndent()
}