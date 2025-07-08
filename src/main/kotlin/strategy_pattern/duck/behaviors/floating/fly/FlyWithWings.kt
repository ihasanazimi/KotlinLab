package strategy_pattern.duck.behaviors.floating.fly

import strategy_pattern.duck.behaviors.fixed.FlyBehavior


class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying with wings!") // من با بال پرواز می‌کنم!
    }
}