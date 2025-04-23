import kotlin.math.PI
import kotlin.math.sin

const val PI = 3.1415926535
const val USD_TO_EUR = 0.85
const val USD_TO_GBP = 0.74
const val USD_TO_JPY = 110.16
const val USD_TO_RUB = 81.46


fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))

    println("Задача 1")
    val name: String = "Maria"
    val age: Int = 23
    val info: Boolean = false
    val language: String = "C#"

    println("Имя: $name")
    println("Возраст: $age")
    println("Информация: $info")
    println("Язык: $language")

    println("Задача 2")
    val circleRadius = 5.0    // радиус круга
    val squareSide = 4.0      // сторона квадрата

    val circleArea = PI * circleRadius * circleRadius
    val squareArea = squareSide * squareSide

    println("Площадь круга: $circleArea")
    println("Площадь квадрата: $squareArea")

    println("Сторона квадрата: $squareSide")
    println("Радиус круга: $circleRadius")

    println("Задача 3")
    println("Введите количество секунд:")

    try {
        val input = readlnOrNull() ?: throw NumberFormatException()
        val totalSeconds = input.toInt()

        if (totalSeconds < 0) {
            println("Ошибка: количество секунд не может быть отрицательным")
            return
        }

        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        println("Результат: $hours часов, $minutes минут, $seconds секунд")
    } catch (e: NumberFormatException) {
        println("Ошибка: введите целое число")
    }

    println("Задача 4")
    println("Введите сумму в долларах США:")

    try {
        val input = readlnOrNull() ?: throw NumberFormatException()
        val usdAmount = input.toDouble()

        if (usdAmount < 0) {
            println("Ошибка: сумма не может быть отрицательной")
            return
        }

        val eurAmount = usdAmount * USD_TO_EUR
        val gbpAmount = usdAmount * USD_TO_GBP
        val jpyAmount = usdAmount * USD_TO_JPY
        val rubAmount = usdAmount * USD_TO_RUB

        println("\nРезультаты конвертации:")
        println("USD: ${usdAmount} USD")
        println("EUR: ${eurAmount} EUR")
        println("GBP: ${gbpAmount} GBP")
        println("JPY: ${jpyAmount} JPY")
        println("RUB: ${rubAmount} RUB")

    } catch (e: NumberFormatException) {
        println("Ошибка: введите корректную сумму (число)")
    }

    println("Задача 5")

    val currentDay = 23
    val currentMonth = 4
    val currentYear = 2025

    println("Расчет биоритмов на $currentDay.$currentMonth.$currentYear")
    println("Введите дату вашего рождения:")

    println("День: ")
    val birthDay = readLine()?.toIntOrNull()

    println("Месяц: ")
    val birthMonth = readLine()?.toIntOrNull()

    println("Год: ")
    val birthYear = readLine()?.toIntOrNull()

    if (birthYear != null && birthYear <= 0 || birthMonth != null && birthMonth <= 0 || birthDay != null && birthDay <= 0) {
        println("Ошибка: Некорректная дата рождения")
        return
    }

    if (birthYear == null || birthMonth == null || birthDay == null) {
        println("Ошибка: Введите корректную дату рождения")
        return
    }

    if (birthYear > currentYear || (birthYear == currentYear && birthMonth > currentMonth) || (birthYear == currentYear && birthMonth == currentMonth && birthDay > currentDay)) {
        println("Ошибка: Дата рождения не может быть в будущем")
        return
    }

    val years = currentYear - birthYear
    val months = currentMonth - birthMonth
    val days = currentDay - birthDay

    val totalDays = years * 365 + months * 30 + days

    val physical = sin(2 * PI * totalDays / 23) * 100
    val emotional = sin(2 * PI * totalDays / 28) * 100
    val intellectual = sin(2 * PI * totalDays / 33) * 100

    println("\nРезультаты биоритмов:")
    println("Физический (23-дневный цикл): ${physical}%")
    println("Эмоциональный (28-дневный цикл): ${emotional}%")
    println("Интеллектуальный (33-дневный цикл): ${intellectual}%")

    println("\nСостояние биоритмов:")

    val physicalStatus = when {
        physical > 80 -> "Пик энергии! Идеальное время для физической активности"
        physical > 30 -> "Хорошая форма, можно заниматься спортом"
        physical > -30 -> "Обычный уровень энергии"
        physical > -80 -> "Сниженная энергия, будьте осторожны"
        else -> "Критически низкий уровень, требуется отдых"
    }

    val emotionalStatus = when {
        emotional > 80 -> "Отличное настроение! Эмоциональный подъем"
        emotional > 30 -> "Хорошее настроение, стабильное состояние"
        emotional > -30 -> "Нормальное эмоциональное состояние"
        emotional > -80 -> "Эмоциональный спад, возможна раздражительность"
        else -> "Сильный эмоциональный кризис, будьте внимательны к себе"
    }

    val intellectualStatus = when {
        intellectual > 80 -> "Ясность мышления! Отличное время для обучения и творчества"
        intellectual > 30 -> "Хорошая умственная активность"
        intellectual > -30 -> "Стандартный уровень интеллектуальной активности"
        intellectual > -80 -> "Сниженная концентрация, возможны ошибки"
        else -> "Критически низкий уровень, избегайте важных решений"
    }

    println("- Физический: $physicalStatus")
    println("- Эмоциональный: $emotionalStatus")
    println("- Интеллектуальный: $intellectualStatus")

}