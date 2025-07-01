package strategy.car.behavior.floating.fuel

import strategy.car.behavior.fixed.FuelBehavior

class NoConsumerFuel : FuelBehavior{
    override fun consumerFuel() {
        TODO("Not yet implemented")
    }

    override fun noFuel() {
        super.noFuel()
    }
}