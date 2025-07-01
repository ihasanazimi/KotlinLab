package strategy.duck.behaviors.floating.fly

import strategy.duck.behaviors.fixed.FlyBehavior


class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying with wings!") // من با بال پرواز می‌کنم!
    }
}