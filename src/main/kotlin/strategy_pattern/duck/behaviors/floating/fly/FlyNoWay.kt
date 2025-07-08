package strategy_pattern.duck.behaviors.floating.fly

import strategy_pattern.duck.behaviors.fixed.FlyBehavior

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly") // من نمی‌توانم پرواز کنم
    }
}