package strategy_pattern.duck.behaviors.floating.quack

import strategy_pattern.duck.behaviors.fixed.QuackBehavior


class Squeak : QuackBehavior {
    override fun quack() {
        println("Squeak!") // جیک‌جیک!
    }
}