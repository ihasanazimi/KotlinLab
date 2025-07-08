package factory_pattern.pizza.abstraction

import factory_pattern.pizza.factory.Pizza
import factory_pattern.pizza.factory.PizzaStore

// واسط‌های مواد اولیه (Abstractions)
interface Dough { fun getDescription(): String }
interface Sauce { fun getDescription(): String }
interface Cheese { fun getDescription(): String }
// ... سایر مواد اولیه

// پیاده‌سازی‌های خاص مواد اولیه برای نیویورک
class ThinCrustDough : Dough { override fun getDescription() = "Thin Crust Dough" }
class MarinaraSauce : Sauce { override fun getDescription() = "Marinara Sauce" }
class ReggianoCheese : Cheese { override fun getDescription() = "Reggiano Cheese" }

// پیاده‌سازی‌های خاص مواد اولیه برای شیکاگو
class ThickCrustDough : Dough { override fun getDescription() = "Thick Crust Dough" }
class PlumTomatoSauce : Sauce { override fun getDescription() = "Plum Tomato Sauce" }
class MozzarellaCheese : Cheese { override fun getDescription() = "Mozzarella Cheese" }

// واسط Abstract Factory برای مواد اولیه پیتزا
interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    // ... سایر متدهای ساخت مواد اولیه
}

// Concrete Factory برای مواد اولیه نیویورک
class NYPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = ThinCrustDough()
    override fun createSauce(): Sauce = MarinaraSauce()
    override fun createCheese(): Cheese = ReggianoCheese()
}

// Concrete Factory برای مواد اولیه شیکاگو
class ChicagoPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = ThickCrustDough()
    override fun createSauce(): Sauce = PlumTomatoSauce()
    override fun createCheese(): Cheese = MozzarellaCheese()
}

// حالا کلاس Pizza تغییر می‌کند تا از Factory مواد اولیه استفاده کند
abstract class AbstractPizza : Pizza { // تغییر نام برای جلوگیری از تداخل با واسط Pizza قبلی
    lateinit var dough: Dough
    lateinit var sauce: Sauce
    lateinit var cheese: Cheese
    // ... سایر مواد اولیه

    abstract override fun prepare() // متد prepare انتزاعی می‌شود
}

class CheesePizzaWithIngredients(private val ingredientFactory: PizzaIngredientFactory) : AbstractPizza() {
    override var name: String = "Cheese Pizza" // نام را در اینجا تنظیم می‌کنیم

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

// حالا PizzaStore (که از Factory Method استفاده می‌کند) از Abstract Factory مواد اولیه استفاده می‌کند
abstract class PizzaStoreWithAbstractFactory : PizzaStore() { // تغییر نام برای جلوگیری از تداخل
    // createPizza همچنان Factory Method است
    // اما حالا از یک PizzaIngredientFactory استفاده می‌کند
}

class NYPizzaStoreWithIngredients : PizzaStoreWithAbstractFactory() {
    override fun createPizza(type: String): Pizza {
        val ingredientFactory = NYPizzaIngredientFactory() // ساخت Factory مواد اولیه خاص نیویورک
        return when (type) {
            "cheese" -> CheesePizzaWithIngredients(ingredientFactory).apply { name = "NY Style Cheese Pizza" }
            // ... سایر پیتزاهای نیویورکی با مواد اولیه نیویورکی
            else -> throw IllegalArgumentException("Unknown NY pizza type")
        }
    }
}

class ChicagoPizzaStoreWithIngredients : PizzaStoreWithAbstractFactory() {
    override fun createPizza(type: String): Pizza {
        val ingredientFactory = ChicagoPizzaIngredientFactory() // ساخت Factory مواد اولیه خاص شیکاگو
        return when (type) {
            "cheese" -> CheesePizzaWithIngredients(ingredientFactory).apply { name = "Chicago Style Cheese Pizza" }
            // ... سایر پیتزاهای شیکاگویی با مواد اولیه شیکاگویی
            else -> throw IllegalArgumentException("Unknown Chicago pizza type")
        }
    }
}

fun main() {
    val nyStore = NYPizzaStoreWithIngredients()
    val chicagoStore = ChicagoPizzaStoreWithIngredients()

    val ethanPizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a ${ethanPizza.name}\n")

    val joelPizza = chicagoStore.orderPizza("cheese")
    println("Joel ordered a ${joelPizza.name}\n")
}
