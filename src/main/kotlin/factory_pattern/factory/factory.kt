package factory_pattern.factory

// واسط یا کلاس انتزاعی Pizza (همون قبلی)
interface Pizza {
    var name: String
    fun prepare()
    fun bake()
    fun cut()
    fun box()
}

// کلاس انتزاعی PizzaStore (Creator)
abstract class PizzaStore {
    // این متد الگوریتم کلی سفارش پیتزا را تعریف می‌کند
    fun orderPizza(type: String): Pizza {
        val pizza = createPizza(type) // فراخوانی متد کارخانه‌ای برای ساخت پیتزا

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    // متد کارخانه‌ای (Factory Method) - انتزاعی است و توسط زیرکلاس‌ها پیاده‌سازی می‌شود
    protected abstract fun createPizza(type: String): Pizza
}

// کلاس‌های خاص پیتزا برای نیویورک
class NYStyleCheesePizza : Pizza {
    override var name: String = "NY Style Sauce and Cheese Pizza"
    override fun prepare() { println("Preparing NY Style Cheese Pizza") }
    override fun bake() { println("Baking NY Style Cheese Pizza") }
    override fun cut() { println("Cutting NY Style Cheese Pizza") }
    override fun box() { println("Boxing NY Style Cheese Pizza") }
}

// کلاس‌های خاص پیتزا برای شیکاگو
class ChicagoStyleCheesePizza : Pizza {
    override var name: String = "Chicago Style Deep Dish Cheese Pizza"
    override fun prepare() { println("Preparing Chicago Style Deep Dish Cheese Pizza") }
    override fun bake() { println("Baking Chicago Style Deep Dish Cheese Pizza") }
    override fun cut() { println("Cutting Chicago Style Deep Dish Cheese Pizza into square slices") } // برش مربعی
    override fun box() { println("Boxing Chicago Style Deep Dish Cheese Pizza") }
}

// زیرکلاس NYPizzaStore (Concrete Creator)
class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> NYStyleCheesePizza()
            // ... سایر پیتزاهای نیویورکی
            else -> throw IllegalArgumentException("Unknown NY pizza type")
        }
    }
}

// زیرکلاس ChicagoPizzaStore (Concrete Creator)
class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> ChicagoStyleCheesePizza()
            // ... سایر پیتزاهای شیکاگویی
            else -> throw IllegalArgumentException("Unknown Chicago pizza type")
        }
    }
}

fun main() {
    val nyStore = NYPizzaStore()
    val chicagoStore = ChicagoPizzaStore()

    val ethanPizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a ${ethanPizza.name}\n")

    val joelPizza = chicagoStore.orderPizza("cheese")
    println("Joel ordered a ${joelPizza.name}\n")
}
