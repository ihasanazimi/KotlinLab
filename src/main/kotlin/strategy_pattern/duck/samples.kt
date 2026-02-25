package strategy_pattern.duck

import strategy_pattern.duck.behaviors.Duck
import strategy_pattern.duck.behaviors.fixed.FlyBehavior
import strategy_pattern.duck.behaviors.floating.fly_behavior_impls.FlyNoWay
import strategy_pattern.duck.behaviors.floating.fly_behavior_impls.FlyWithWings
import strategy_pattern.duck.behaviors.floating.quack_behavior_impls.Quack

/*---------------------------------------------------------------------------------------------------------------------*/


class FlyRocketPowered : FlyBehavior {
    override fun fly() {
        println("I'm flying with a rocket!")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class MallardDuck : Duck() {
    init {
        quackBehavior = Quack()
        flyBehavior = FlyWithWings()
    }

    override fun display() {
        println("I'm a real Mallard strategy.duck")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class ModelDuck : Duck(){

    init {
        flyBehavior = FlyNoWay()
        quackBehavior = Quack()
    }

    override fun display() {
        println("i am model dock")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


fun main() {
    val mallard = MallardDuck()
    mallard.performQuack() // Quack!
    mallard.performFly()   // I'm flying with wings!

    val model = ModelDuck()
    model.performFly()     // I can't fly

    model.replaceFlyBehavior(FlyRocketPowered())
    model.performFly()     // I'm flying with a rocket!
}