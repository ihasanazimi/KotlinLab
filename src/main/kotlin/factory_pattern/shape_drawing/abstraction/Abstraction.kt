package factory_pattern.shape_drawing.abstraction


// واسط‌ها برای اشکال و رنگ‌ها (Abstractions)
interface Shape { fun draw() }
interface Color { fun applyColor() }

// پیاده‌سازی‌های خاص برای اشکال
class Circle : Shape { override fun draw() { println("Drawing a Circle") } }
class Square : Shape { override fun draw() { println("Drawing a Square") } }
class Sphere : Shape { override fun draw() { println("Drawing a 3D Sphere") } }
class Cube : Shape { override fun draw() { println("Drawing a 3D Cube") } }

// پیاده‌سازی‌های خاص برای رنگ‌ها
class RedColor : Color { override fun applyColor() { println("Applying Red Color") } }
class BlueColor : Color { override fun applyColor() { println("Applying Blue Color") } }
class GreenColor : Color { override fun applyColor() { println("Applying Green Color") } }

// واسط Abstract Factory برای ساخت خانواده‌ای از اشیاء (Shape و Color)
interface AbstractFactory {
    fun createShape(type: String): Shape
    fun createColor(type: String): Color
}

// Concrete Factory برای خانواده 2D
class TwoDFactoryImpl : AbstractFactory {
    override fun createShape(type: String): Shape {
        return when (type) {
            "circle" -> Circle()
            "square" -> Square()
            else -> Circle()
        }
    }
    override fun createColor(type: String): Color {
        return when (type) {
            "red" -> RedColor()
            "blue" -> BlueColor()
            else -> RedColor()
        }
    }
}

// Concrete Factory برای خانواده 3D
class ThreeDFactoryImpl : AbstractFactory {
    override fun createShape(type: String): Shape {
        return when (type) {
            "sphere" -> Sphere()
            "cube" -> Cube()
            else -> Sphere()
        }
    }
    override fun createColor(type: String): Color {
        return when (type) {
            "green" -> GreenColor()
            "blue" -> BlueColor()
            else -> GreenColor()
        }
    }
}

// کلاسی که از Abstract Factory استفاده می‌کند
class ClientApp(private val factory: AbstractFactory) {
    fun createAndDrawComplexObject(shapeType: String, colorType: String) {
        val shape = factory.createShape(shapeType)
        val color = factory.createColor(colorType)
        shape.draw()
        color.applyColor()
    }
}

fun main() {
    // استفاده از کارخانه 2D
    val twoDFactory = TwoDFactoryImpl()
    val client2D = ClientApp(twoDFactory)
    client2D.createAndDrawComplexObject("circle", "red") // خروجی: Drawing a Circle ... Applying Red Color

    println("---")

    // استفاده از کارخانه 3D
    val threeDFactory = ThreeDFactoryImpl()
    val client3D = ClientApp(threeDFactory)
    client3D.createAndDrawComplexObject("sphere", "green") // خروجی: Drawing a 3D Sphere ... Applying Green Color
}