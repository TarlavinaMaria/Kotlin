/**
 * Абстрактный класс Shape с методом вычисления площади
 */
abstract class Shape {
    /**
     * Вычисляет площадь фигуры
     * @return Площадь фигуры
     */
    abstract fun area(): Double
}

/**
 * Интерфейс для отрисовки фигур
 */
interface Drawable {
    /**
     * Отрисовывает фигуру
     */
    fun draw()
}

/**
 * Класс Circle, реализующий Shape и Drawable
 * @property radius Радиус круга
 */
class Circle(private val radius: Double) : Shape(), Drawable {
    /**
     * Вычисляет площадь круга
     * @return Площадь круга
     */
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    /**
     * Отрисовывает круг в консоли
     */
    override fun draw() {
        println("Рисуем круг")
        println("   ***  ")
        println(" *     * ")
        println("*       *")
        println(" *     * ")
        println("   ***  ")
    }
}

/**
 * Класс Rectangle, реализующий Shape и Drawable
 * @property width Ширина прямоугольника
 * @property height Высота прямоугольника
 */
class Rectangle(private val width: Double, private val height: Double) : Shape(), Drawable {
    /**
     * Вычисляет площадь прямоугольника
     * @return Площадь прямоугольника
     */
    override fun area(): Double {
        return width * height
    }

    /**
     * Отрисовывает прямоугольник в консоли
     */
    override fun draw() {
        println("Рисуем прямоугольник")
        println("******")
        println("*    *")
        println("*    *")
        println("******")
    }
}

/**
 * Класс Triangle, реализующий Shape и Drawable
 * @property base Основание треугольника
 * @property height Высота треугольника
 */
class Triangle(private val base: Double, private val height: Double) : Shape(), Drawable {
    /**
     * Вычисляет площадь треугольника
     * @return Площадь треугольника
     */
    override fun area(): Double {
        return 0.5 * base * height
    }

    /**
     * Отрисовывает треугольник в консоли
     */
    override fun draw() {
        println("Рисуем треугольник")
        println("  *  ")
        println(" * * ")
        println("*****")
    }
}