package factory_pattern.shape_drawing.simple

// واسط و کلاس‌های Shape (همون قبلی)
interface Shape { fun draw() }
class Circle : Shape { override fun draw() { println("Drawing a Circle") } }
class Square : Shape { override fun draw() { println("Drawing a Square") } }
class Triangle : Shape { override fun draw() { println("Drawing a Triangle") } }

// کلاس SimpleShapeFactory: این کارخانه فقط کارش ساختن شکله
class SimpleShapeFactory {
    fun createShape(type: String): Shape {
        return when (type) {
            "circle" -> Circle()
            "square" -> Square()
            "triangle" -> Triangle()
            else -> throw IllegalArgumentException("Unknown shape type")
        }
    }
}

// حالا DrawingApp از کارخانه استفاده می‌کند
class DrawingAppWithFactory(private val factory: SimpleShapeFactory) {
    fun drawShape(type: String) {
        val shape = factory.createShape(type) // ساخت شکل را به کارخانه محول می‌کند
        shape.draw()
    }
}

fun main() {
    val factory = SimpleShapeFactory()
    val app = DrawingAppWithFactory(factory)
    app.drawShape("circle")
    app.drawShape("square")
    // اگه شکل جدیدی اضافه بشه، فقط SimpleShapeFactory نیاز به تغییر داره، نه DrawingAppWithFactory
}
