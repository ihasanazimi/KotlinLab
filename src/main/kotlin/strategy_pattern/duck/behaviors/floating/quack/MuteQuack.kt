package strategy_pattern.duck.behaviors.floating.quack

import strategy_pattern.duck.behaviors.fixed.QuackBehavior


class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence >>") // << سکوت >>
    }
}