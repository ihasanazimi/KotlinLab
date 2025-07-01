package strategy.car.behavior.floating.brake

import strategy.car.behavior.fixed.BrakeBehavior

class Brakeable  : BrakeBehavior {
    override fun brake() {
        println("brake system is -> Brakeable")
    }
}