package strategy_pattern.duck.behaviors.floating.quack_behavior_impls

import strategy_pattern.duck.behaviors.fixed.QuackBehavior


/*---------------------------------------------------------------------------------------------------------------------*/

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence >>")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


class Quack : QuackBehavior {
    override fun quack() {
        println("Quack!")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


class Squeak : QuackBehavior {
    override fun quack() {
        println("Squeak!")
    }
}