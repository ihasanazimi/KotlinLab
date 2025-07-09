package factory_pattern.shape_drawing.simple


interface Shape { fun draw() }
class Circle : Shape { override fun draw() { println("Drawing a Circle") } }
class Square : Shape { override fun draw() { println("Drawing a Square") } }
class Triangle : Shape { override fun draw() { println("Drawing a Triangle") } }


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


class DrawingAppWithFactory(private val factory: SimpleShapeFactory) {
    fun drawShape(type: String) {
        val shape = factory.createShape(type)
        shape.draw()
    }
}

fun main() {
    val factory = SimpleShapeFactory()
    val app = DrawingAppWithFactory(factory)
    app.drawShape("circle")
    app.drawShape("square")
}
