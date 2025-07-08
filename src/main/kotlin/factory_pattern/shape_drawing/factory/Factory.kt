package factory_pattern.shape_drawing.factory

// واسط و کلاس‌های Shape (همون قبلی)
interface Shape { fun draw() }
class Circle : Shape { override fun draw() { println("Drawing a Circle") } }
class Square : Shape { override fun draw() { println("Drawing a Square") } }
class Triangle : Shape { override fun draw() { println("Drawing a Triangle") } }

// کلاس‌های خاص برای اشکال پیشرفته (مثلاً 3D)
private class Sphere : Shape {
    override fun draw() {
        println("Drawing a 3D Sphere")
    }
}

private class Cube : Shape {
    override fun draw() {
        println("Drawing a 3D Cube")
    }
}

// کلاس انتزاعی Application (Creator)
abstract class Application {
    // این متد الگوریتم کلی استفاده از شکل را تعریف می‌کند
    fun openDocument() {
        val shape = createShape("default") // فراخوانی متد کارخانه‌ای برای ساخت شکل
        shape.draw()
        println("Document opened with a default shape.")
    }

    // متد کارخانه‌ای (Factory Method) - انتزاعی است و توسط زیرکلاس‌ها پیاده‌سازی می‌شود
    protected abstract fun createShape(type: String): Shape
}

// زیرکلاس SimpleDrawingApplication (Concrete Creator)
private class SimpleDrawingApplication : Application() {
    override fun createShape(type: String): Shape {
        println("Simple app is creating a shape...")
        return when (type) {
            "circle" -> Circle()
            "square" -> Square()
            else -> Circle() // پیش‌فرض برای سادگی
        }
    }
}

// زیرکلاس AdvancedDrawingApplication (Concrete Creator)
private class AdvancedDrawingApplication : Application() {
    override fun createShape(type: String): Shape {
        println("Advanced app is creating a shape...")
        return when (type) {
            "sphere" -> Sphere()
            "cube" -> Cube()
            else -> Sphere() // پیش‌فرض برای سادگی
        }
    }
}

fun main() {
    val simpleApp = SimpleDrawingApplication()
    simpleApp.openDocument() // خروجی: Simple app is creating a shape... Drawing a Circle ...

    val advancedApp = AdvancedDrawingApplication()
    advancedApp.openDocument() // خروجی: Advanced app is creating a shape... Drawing a 3D Sphere ...
}