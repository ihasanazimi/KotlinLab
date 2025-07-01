package strategy.car.behavior.floating.fuel

import strategy.car.behavior.fixed.FuelBehavior

class YesConsumerFuel(private val fuelType: String) : FuelBehavior{
    override fun consumerFuel() {
        println("fuel type is $fuelType")
    }
}