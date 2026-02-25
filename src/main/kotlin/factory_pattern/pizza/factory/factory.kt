package factory_pattern.pizza.factory

/*---------------------------------------------------------------------------------------------------------------------*/

interface Pizza {
    var name: String
    fun prepare()
    fun bake()
    fun cut()
    fun box()
}

/*---------------------------------------------------------------------------------------------------------------------*/

abstract class PizzaStore {
    fun orderPizza(type: String): Pizza {
        val pizza = createPizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    protected abstract fun createPizza(type: String): Pizza
}

/*---------------------------------------------------------------------------------------------------------------------*/

class NYStyleCheesePizza : Pizza {
    override var name: String = "NY Style Sauce and Cheese Pizza"
    override fun prepare() { println("Preparing NY Style Cheese Pizza") }
    override fun bake() { println("Baking NY Style Cheese Pizza") }
    override fun cut() { println("Cutting NY Style Cheese Pizza") }
    override fun box() { println("Boxing NY Style Cheese Pizza") }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class ChicagoStyleCheesePizza : Pizza {
    override var name: String = "Chicago Style Deep Dish Cheese Pizza"
    override fun prepare() { println("Preparing Chicago Style Deep Dish Cheese Pizza") }
    override fun bake() { println("Baking Chicago Style Deep Dish Cheese Pizza") }
    override fun cut() { println("Cutting Chicago Style Deep Dish Cheese Pizza into square slices") }
    override fun box() { println("Boxing Chicago Style Deep Dish Cheese Pizza") }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> NYStyleCheesePizza()
            else -> throw IllegalArgumentException("Unknown NY pizza type")
        }
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> ChicagoStyleCheesePizza()
            else -> throw IllegalArgumentException("Unknown Chicago pizza type")
        }
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

fun main() {
    val nyStore = NYPizzaStore()
    val chicagoStore = ChicagoPizzaStore()

    val ethanPizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a ${ethanPizza.name}\n")

    val joelPizza = chicagoStore.orderPizza("cheese")
    println("Joel ordered a ${joelPizza.name}\n")
}
