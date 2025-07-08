package strategy_pattern.car.behavior.fixed

interface FuelBehavior {
    fun consumerFuel()
    fun noFuel(){
        println("noFuel")
    }
}