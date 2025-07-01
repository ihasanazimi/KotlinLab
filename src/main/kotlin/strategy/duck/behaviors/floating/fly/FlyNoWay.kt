package strategy.duck.behaviors.floating.fly

import strategy.duck.behaviors.fixed.FlyBehavior

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly") // من نمی‌توانم پرواز کنم
    }
}