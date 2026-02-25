package factory_pattern.shape_drawing.factory

/*---------------------------------------------------------------------------------------------------------------------*/
interface Shape { fun draw() }
class Circle : Shape { override fun draw() { println("Drawing a Circle") } }
class Square : Shape { override fun draw() { println("Drawing a Square") } }
class Triangle : Shape { override fun draw() { println("Drawing a Triangle") } }
/*---------------------------------------------------------------------------------------------------------------------*/

private class Sphere : Shape {
    override fun draw() {
        println("Drawing a 3D Sphere")
    }
}
/*---------------------------------------------------------------------------------------------------------------------*/
private class Cube : Shape {
    override fun draw() {
        println("Drawing a 3D Cube")
    }
}
/*---------------------------------------------------------------------------------------------------------------------*/

abstract class Application {

    fun openDocument() {
        val shape = createShape("default")
        shape.draw()
        println("Document opened with a default shape.")
    }


    protected abstract fun createShape(type: String): Shape
}

/*---------------------------------------------------------------------------------------------------------------------*/
private class SimpleDrawingApplication : Application() {
    override fun createShape(type: String): Shape {
        println("Simple app is creating a shape...")
        return when (type) {
            "circle" -> Circle()
            "square" -> Square()
            else -> Circle()
        }
    }
}
/*---------------------------------------------------------------------------------------------------------------------*/

private class AdvancedDrawingApplication : Application() {
    override fun createShape(type: String): Shape {
        println("Advanced app is creating a shape...")
        return when (type) {
            "sphere" -> Sphere()
            "cube" -> Cube()
            else -> Sphere()
        }
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

fun main() {
    val simpleApp = SimpleDrawingApplication()
    simpleApp.openDocument()

    val advancedApp = AdvancedDrawingApplication()
    advancedApp.openDocument()
}