package decorator.starbuzz

import decorator.starbuzz.base.Beverage
import decorator.starbuzz.products.*

fun main() {
    // سفارش 1: فقط اسپرسو
    val beverage1: Beverage = Espresso()
    println("${beverage1.getBeverageDescription()} $${beverage1.cost()}") // خروجی: Espresso $1.99

    // سفارش 2: دارک روست با دو موکا و خامه
    var beverage2: Beverage = HouseBlend() // شروع با HouseBlend
    beverage2 = Mocha(beverage2)           // پیچیدن با موکا
    beverage2 = Mocha(beverage2)           // پیچیدن با موکا دوم
    beverage2 = Whip(beverage2)            // پیچیدن با خامه
    println("${beverage2.getBeverageDescription()} $${beverage2.cost()}") // خروجی: House Blend Coffee, Mocha, Mocha, Whip $cost

    // سفارش 3: هاوس بلند با سویا، موکا و خامه
    var beverage3: Beverage = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    println("${beverage3.getBeverageDescription()} $${beverage3.cost()}") // خروجی: House Blend Coffee, Soy, Mocha, Whip $cost
}