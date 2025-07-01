package strategy.duck.behaviors

import strategy.duck.behaviors.fixed.FlyBehavior
import strategy.duck.behaviors.fixed.QuackBehavior

abstract class Duck {
    var flyBehavior : FlyBehavior?= null
    var quackBehavior : QuackBehavior?= null



    fun swim() {
        println("All ducks float, even decoys!")
    }

    abstract fun display()



    fun performFly() {
        flyBehavior?.fly() // محول کردن پرواز به شیء FlyBehavior
    }



    fun performQuack() {
        quackBehavior?.quack() // محول کردن کواک به شیء QuackBehavior
    }


    // متدهای setter برای تغییر دینامیکی رفتار در زمان اجرا
    fun replaceFlyBehavior(fb: FlyBehavior) {
        flyBehavior = fb
    }



    fun replaceQuackBehavior(qb: QuackBehavior) {
        quackBehavior = qb
    }
}