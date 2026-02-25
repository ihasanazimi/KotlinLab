package factory_pattern.pizza.abstraction

import factory_pattern.pizza.factory.Pizza
import factory_pattern.pizza.factory.PizzaStore

/*---------------------------------------------------------------------------------------------------------------------*/

interface Dough { fun getDescription(): String }
interface Sauce { fun getDescription(): String }
interface Cheese { fun getDescription(): String }

/*---------------------------------------------------------------------------------------------------------------------*/

class ThinCrustDough : Dough { override fun getDescription() = "Thin Crust Dough" }
class MarinaraSauce : Sauce { override fun getDescription() = "Marinara Sauce" }
class ReggianoCheese : Cheese { override fun getDescription() = "Reggiano Cheese" }

/*---------------------------------------------------------------------------------------------------------------------*/

class ThickCrustDough : Dough { override fun getDescription() = "Thick Crust Dough" }
class PlumTomatoSauce : Sauce { override fun getDescription() = "Plum Tomato Sauce" }
class MozzarellaCheese : Cheese { override fun getDescription() = "Mozzarella Cheese" }

/*---------------------------------------------------------------------------------------------------------------------*/

interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
}

/*---------------------------------------------------------------------------------------------------------------------*/

class NYPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = ThinCrustDough()
    override fun createSauce(): Sauce = MarinaraSauce()
    override fun createCheese(): Cheese = ReggianoCheese()
}

/*---------------------------------------------------------------------------------------------------------------------*/

class ChicagoPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = ThickCrustDough()
    override fun createSauce(): Sauce = PlumTomatoSauce()
    override fun createCheese(): Cheese = MozzarellaCheese()
}

/*---------------------------------------------------------------------------------------------------------------------*/

abstract class AbstractPizza : Pizza {
    lateinit var dough: Dough
    lateinit var sauce: Sauce
    lateinit var cheese: Cheese
    abstract override fun prepare()
}

/*---------------------------------------------------------------------------------------------------------------------*/

class CheesePizzaWithIngredients(private val ingredientFactory: PizzaIngredientFactory) : AbstractPizza() {
    override var name: String = "Cheese Pizza"

    override fun prepare() {
        println("Preparing $name")
        dough = ingredientFactory.createDough()
        sauce = ingredientFactory.createSauce()
        cheese = ingredientFactory.createCheese()
        println("Adding ${dough.getDescription()}, ${sauce.getDescription()}, ${cheese.getDescription()}")
    }
    override fun bake() { println("Baking...") }
    override fun cut() { println("Cutting...") }
    override fun box() { println("Boxing...") }
}

/*---------------------------------------------------------------------------------------------------------------------*/

abstract class PizzaStoreWithAbstractFactory : PizzaStore() {
    // todo
}

/*---------------------------------------------------------------------------------------------------------------------*/

class NYPizzaStoreWithIngredients : PizzaStoreWithAbstractFactory() {
    override fun createPizza(type: String): Pizza {
        val ingredientFactory = NYPizzaIngredientFactory()
        return when (type) {
            "cheese" -> CheesePizzaWithIngredients(ingredientFactory).apply { name = "NY Style Cheese Pizza" }
            else -> throw IllegalArgumentException("Unknown NY pizza type")
        }
    }
}
/*---------------------------------------------------------------------------------------------------------------------*/


class ChicagoPizzaStoreWithIngredients : PizzaStoreWithAbstractFactory() {
    override fun createPizza(type: String): Pizza {
        val ingredientFactory = ChicagoPizzaIngredientFactory()
        return when (type) {
            "cheese" -> CheesePizzaWithIngredients(ingredientFactory).apply { name = "Chicago Style Cheese Pizza" }
            else -> throw IllegalArgumentException("Unknown Chicago pizza type")
        }
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

fun main() {
    val nyStore = NYPizzaStoreWithIngredients()
    val chicagoStore = ChicagoPizzaStoreWithIngredients()

    val ethanPizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a ${ethanPizza.name}\n")

    val joelPizza = chicagoStore.orderPizza("cheese")
    println("Joel ordered a ${joelPizza.name}\n")
}
