package factory_pattern.shape_drawing.abstraction


/*---------------------------------------------------------------------------------------------------------------------*/

interface Shape { fun draw() }
interface Color { fun applyColor() }

/*---------------------------------------------------------------------------------------------------------------------*/

class Circle : Shape { override fun draw() { println("Drawing a Circle") } }
class Square : Shape { override fun draw() { println("Drawing a Square") } }
class Sphere : Shape { override fun draw() { println("Drawing a 3D Sphere") } }
class Cube : Shape { override fun draw() { println("Drawing a 3D Cube") } }

/*---------------------------------------------------------------------------------------------------------------------*/

class RedColor : Color { override fun applyColor() { println("Applying Red Color") } }
class BlueColor : Color { override fun applyColor() { println("Applying Blue Color") } }
class GreenColor : Color { override fun applyColor() { println("Applying Green Color") } }


/*---------------------------------------------------------------------------------------------------------------------*/
interface AbstractFactory {
    fun createShape(type: String): Shape
    fun createColor(type: String): Color
}


/*---------------------------------------------------------------------------------------------------------------------*/

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

/*---------------------------------------------------------------------------------------------------------------------*/

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

/*---------------------------------------------------------------------------------------------------------------------*/
class ClientApp(private val factory: AbstractFactory) {
    fun createAndDrawComplexObject(shapeType: String, colorType: String) {
        val shape = factory.createShape(shapeType)
        val color = factory.createColor(colorType)
        shape.draw()
        color.applyColor()
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/
fun main() {

    val twoDFactory = TwoDFactoryImpl()
    val client2D = ClientApp(twoDFactory)
    client2D.createAndDrawComplexObject("circle", "red")

    println("---")

    val threeDFactory = ThreeDFactoryImpl()
    val client3D = ClientApp(threeDFactory)
    client3D.createAndDrawComplexObject("sphere", "green")
}