package singleton_pattern.chocolate_boiler.modern_method

enum class EnumChocolateBoiler {

    UNIQUE_INSTANCE;

    private var empty: Boolean = true
    private var boiled: Boolean = false

    /*پر کردن * */
    fun fill() {
        if (isEmpty()) {
            empty = false
            boiled = false
            println("Boiler filled with milk and chocolate (Enum)")
        }
    }

    /*تخلیه کردن * */
    fun drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true
            println("Boiler drained (Enum)")
        }
    }

    /*جوشاندن * */
    fun boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true
            println("Contents are boiling (Enum)")
        }
    }

    private fun isEmpty(): Boolean = empty
    private fun isBoiled(): Boolean = boiled
}

fun main() {
    val boiler1 = EnumChocolateBoiler.UNIQUE_INSTANCE
    boiler1.fill()
    boiler1.boil()

    val boiler2 = EnumChocolateBoiler.UNIQUE_INSTANCE
    println("Are boiler1 and boiler2 the same instance? ${boiler1 === boiler2}")
    boiler2.drain()
}