package strategy_pattern.car.behavior.fixed

interface BrakeBehavior {
    fun brake()
}



interface FuelBehavior {
    fun consumerFuel()
    fun noFuel(){
        println("noFuel")
    }
}


interface LightTechBehavior {
    fun lightTech()
}