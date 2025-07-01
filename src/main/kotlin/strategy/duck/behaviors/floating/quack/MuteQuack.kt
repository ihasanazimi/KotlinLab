package strategy.duck.behaviors.floating.quack

import strategy.duck.behaviors.fixed.QuackBehavior


class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence >>") // << سکوت >>
    }
}