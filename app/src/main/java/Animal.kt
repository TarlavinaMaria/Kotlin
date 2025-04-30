/**
 * Базовый класс Animal с методом издания звука
 */
open class Animal {
    /**
     * Издаёт звук животного (базовая реализация)
     */
    open fun makeSound() = println("Издаёт звук")
}

/**
 * Класс Lion, наследующий Animal
 */
class Lion : Animal() {
    /**
     * Переопределённый метод издания звука для льва
     */
    override fun makeSound() = println("Рррр!")
}

/**
 * Класс Monkey, наследующий Animal
 */
class Monkey : Animal() {
    /**
     * Переопределённый метод издания звука для обезьяны
     */
    override fun makeSound() = println("У-у-у-а-а-а!")
}

/**
 * Демонстрирует звуки животных
 */
fun animalSounds() {
    val animals = listOf(Lion(), Monkey(), Animal())
    animals.forEach { it.makeSound() }
}