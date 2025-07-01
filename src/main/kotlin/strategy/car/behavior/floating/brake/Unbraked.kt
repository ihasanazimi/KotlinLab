package strategy.car.behavior.floating.brake

import strategy.car.behavior.fixed.BrakeBehavior

class Unbraked : BrakeBehavior {
    override fun brake() {
        println("brake system type is -> Unbraked")
    }
}