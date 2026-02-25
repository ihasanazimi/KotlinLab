package factory_pattern.pizza.simple

interface Pizza {
    fun prepare()
    fun bake()
    fun cut()
    fun box()
}

/*---------------------------------------------------------------------------------------------------------------------*/

class CheesePizza : Pizza { /* ... */ override fun prepare() { println("Preparing Cheese Pizza") } override fun bake() { println("Baking Cheese Pizza") } override fun cut() { println("Cutting Cheese Pizza") } override fun box() { println("Boxing Cheese Pizza") } }
class PepperoniPizza : Pizza { /* ... */ override fun prepare() { println("Preparing Pepperoni Pizza") } override fun bake() { println("Baking Pepperoni Pizza") } override fun cut() { println("Cutting Pepperoni Pizza") } override fun box() { println("Boxing Pepperoni Pizza") } }
class ClamPizza : Pizza { /* ... */ override fun prepare() { println("Preparing Clam Pizza") } override fun bake() { println("Baking Clam Pizza") } override fun cut() { println("Cutting Clam Pizza") } override fun box() { println("Boxing Clam Pizza") } }
class VeggiePizza : Pizza { /* ... */ override fun prepare() { println("Preparing Veggie Pizza") } override fun bake() { println("Baking Veggie Pizza") } override fun cut() { println("Cutting Veggie Pizza") } override fun box() { println("Boxing Veggie Pizza") } }

/*---------------------------------------------------------------------------------------------------------------------*/

class SimplePizzaFactory {
    fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> CheesePizza()
            "pepperoni" -> PepperoniPizza()
            "clam" -> ClamPizza()
            "veggie" -> VeggiePizza()
            else -> throw IllegalArgumentException("Unknown pizza type")
        }
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class PizzaStore(private val factory: SimplePizzaFactory) {
    fun orderPizza(type: String): Pizza {
        val pizza = factory.createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

fun main(){
    PizzaStore(SimplePizzaFactory()).apply {
        this@apply.orderPizza("clam").apply{
            prepare()
            bake()
            cut()
            box()
        }
        this@apply.orderPizza("cheese").apply{
            prepare()
            bake()
            cut()
            box()
        }
    }
}