package singleton_pattern.chocolate_boiler.classic_method


/***********************************************************************************************************************/
class ThreadSafeChocolateBoiler private constructor() {
    private var empty: Boolean = true
    private var boiled: Boolean = false

    companion object {
        @Volatile
        private var uniqueInstance: ThreadSafeChocolateBoiler? = null

        @Synchronized
        fun getInstance(): ThreadSafeChocolateBoiler {
            if (uniqueInstance == null) {
                uniqueInstance = ThreadSafeChocolateBoiler()
            }
            return uniqueInstance!!
        }
    }

    fun fill() {
        if (isEmpty()) {
            empty = false
            boiled = false
            println("Boiler filled with milk and chocolate")
        }
    }

    fun drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true
            println("Boiler drained")
        }
    }

    fun boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true
            println("Contents are boiling")
        }
    }

    private fun isEmpty(): Boolean = empty
    private fun isBoiled(): Boolean = boiled
}






/***********************************************************************************************************************/
class EagerChocolateBoiler private constructor() {
    private var empty: Boolean = true
    private var boiled: Boolean = false

    companion object {
        private val uniqueInstance: EagerChocolateBoiler = EagerChocolateBoiler()

        fun getInstance(): EagerChocolateBoiler {
            return uniqueInstance
        }
    }

    fun fill() {
        if (isEmpty()) {
            empty = false
            boiled = false
            println("Boiler filled with milk and chocolate")
        }
    }

    fun drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true
            println("Boiler drained")
        }
    }

    fun boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true
            println("Contents are boiling")
        }
    }

    private fun isEmpty(): Boolean = empty
    private fun isBoiled(): Boolean = boiled
}




/***********************************************************************************************************************/
class DCLChocolateBoiler private constructor() {
    private var empty: Boolean = true
    private var boiled: Boolean = false

    companion object {
        @Volatile
        private var uniqueInstance: DCLChocolateBoiler? = null

        fun getInstance(): DCLChocolateBoiler {
            if (uniqueInstance == null) {
                synchronized(DCLChocolateBoiler::class.java) {
                    if (uniqueInstance == null) {
                        uniqueInstance = DCLChocolateBoiler()
                    }
                }
            }
            return uniqueInstance!!
        }
    }

    fun fill() {
        if (isEmpty()) {
            empty = false
            boiled = false
            println("Boiler filled with milk and chocolate")
        }
    }

    fun drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true
            println("Boiler drained")
        }
    }

    fun boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true
            println("Contents are boiling")
        }
    }

    private fun isEmpty(): Boolean = empty
    private fun isBoiled(): Boolean = boiled

}