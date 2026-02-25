package decorator_pattern


/*---------------------------------------------------------------------------------------------------------------------*/

abstract class Beverage {
    open var description: String = "Unknown Beverage"
    open fun getBeverageDescription(): String {
        return description
    }
    abstract fun cost(): Double
}

/*---------------------------------------------------------------------------------------------------------------------*/

abstract class CondimentDecorator : Beverage() {
    abstract var beverage: Beverage
    abstract override fun getBeverageDescription(): String
}

/*---------------------------------------------------------------------------------------------------------------------*/

class Espresso : Beverage() {
    init {
        description = "Espresso"
    }

    override fun cost(): Double {
        return 1.99
    }
}

class HouseBlend : Beverage() {
    init {
        description = "House Blend Coffee"
    }

    override fun cost(): Double {
        return .89
    }
}


class DarkRoast : Beverage(){

    init {
        description = "DarkRoast Coffee"
    }

    override fun cost(): Double {
        return 0.45
    }
}


class Decaf : Beverage(){

    init {
        description = "Decaf Coffee"
    }

    override fun cost(): Double {
        return 0.95
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class Mocha(override var beverage: Beverage) : CondimentDecorator() {

    override fun getBeverageDescription(): String {
        return "${beverage.getBeverageDescription()}, Mocha"
    }

    override fun cost(): Double {
        return beverage.cost() + .20
    }
}

class Whip(override var beverage: Beverage) : CondimentDecorator() {

    override fun getBeverageDescription(): String {
        return "${beverage.getBeverageDescription()}, Whip"
    }

    override fun cost(): Double {
        return beverage.cost() + .10
    }
}

class Soy(override var beverage: Beverage) : CondimentDecorator() {

    override fun getBeverageDescription(): String {
        return "${beverage.getBeverageDescription()}, Soy"
    }

    override fun cost(): Double {
        return beverage.cost() + .15
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/


fun main() {
    val beverage1: Beverage = Espresso()
    println("${beverage1.getBeverageDescription()} $${beverage1.cost()}")

    var beverage2: Beverage = HouseBlend()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    println("${beverage2.getBeverageDescription()} $${beverage2.cost()}")

    var beverage3: Beverage = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    println("${beverage3.getBeverageDescription()} $${beverage3.cost()}")
}






