package decorator.starbuzz.products

import decorator.starbuzz.base.Beverage
import decorator.starbuzz.base.CondimentDecorator

class Espresso : Beverage() {
    init {
        description = "Espresso"
    }

    override fun cost(): Double {
        return 1.99 // قیمت اسپرسو
    }
}

class HouseBlend : Beverage() {
    init {
        description = "House Blend Coffee"
    }

    override fun cost(): Double {
        return .89 // قیمت House Blend
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




/**********************************************************************************************************************/



class Mocha(override var beverage: Beverage) : CondimentDecorator() {
    // در سازنده، نوشیدنی‌ای که قراره تزیین بشه رو می‌گیریم
    // override var beverage: Beverage باعث میشه که beverage از کلاس پایه CondimentDecorator مقداردهی بشه.

    override fun getBeverageDescription(): String {
        return "${beverage.getBeverageDescription()}, Mocha"
    }

    override fun cost(): Double {
        // قیمت نوشیدنی داخلی رو می‌گیریم و قیمت موکا رو بهش اضافه می‌کنیم
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