package strategy_pattern.duck.behaviors.floating.fly_behavior_impls

import strategy_pattern.duck.behaviors.fixed.FlyBehavior

/*---------------------------------------------------------------------------------------------------------------------*/


class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying with wings!")
    }
}