package strategy.duck.behaviors.floating.quack

import strategy.duck.behaviors.fixed.QuackBehavior


class Squeak : QuackBehavior {
    override fun quack() {
        println("Squeak!") // جیک‌جیک!
    }
}