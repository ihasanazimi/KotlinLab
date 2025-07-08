package strategy_pattern.car.behavior.floating.brake

import strategy_pattern.car.behavior.fixed.BrakeBehavior

class Brakeable  : BrakeBehavior {
    override fun brake() {
        println("brake system is -> Brakeable")
    }
}