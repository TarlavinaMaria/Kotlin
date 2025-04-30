/**
 * Data класс, представляющий пользователя
 * @property name Имя пользователя
 * @property age Возраст пользователя
 */
data class User(val name: String, val age: Int)

/**
 * Обрабатывает список пользователей, выводя информацию о них
 * @param users Список пользователей для обработки
 */
fun processUsers(users: List<User>) {
    println("Список всех пользователей:")
    users.forEach { println("${it.name}, ${it.age} лет") }

    println("\nСовершеннолетние пользователи (отсортированные по имени):")
    users.filter { it.age > 18 }
        .sortedBy { it.name }
        .map { it.name.uppercase() }
        .forEach { println(it) }
}