package strategy_pattern.car.behavior.floating.fuel

import strategy_pattern.car.behavior.fixed.FuelBehavior

class YesConsumerFuel(private val fuelType: String) : FuelBehavior{
    override fun consumerFuel() {
        println("fuel type is $fuelType")
    }
}