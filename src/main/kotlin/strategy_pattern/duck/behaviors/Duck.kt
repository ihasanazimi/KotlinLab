package strategy_pattern.duck.behaviors

import strategy_pattern.duck.behaviors.fixed.FlyBehavior
import strategy_pattern.duck.behaviors.fixed.QuackBehavior

abstract class Duck {
    var flyBehavior : FlyBehavior?= null
    var quackBehavior : QuackBehavior?= null

    fun swim() {
        println("All ducks float, even decoys!")
    }

    abstract fun display()

    fun performFly() {
        flyBehavior?.fly()
    }

    fun performQuack() {
        quackBehavior?.quack()
    }

    fun replaceFlyBehavior(fb: FlyBehavior) {
        flyBehavior = fb
    }

    fun replaceQuackBehavior(qb: QuackBehavior) {
        quackBehavior = qb
    }
}