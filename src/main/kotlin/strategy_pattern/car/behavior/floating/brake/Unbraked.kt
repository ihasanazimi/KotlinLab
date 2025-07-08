package strategy_pattern.car.behavior.floating.brake

import strategy_pattern.car.behavior.fixed.BrakeBehavior

class Unbraked : BrakeBehavior {
    override fun brake() {
        println("brake system type is -> Unbraked")
    }
}