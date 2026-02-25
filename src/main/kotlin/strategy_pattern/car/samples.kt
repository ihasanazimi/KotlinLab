package strategy_pattern.car

import strategy_pattern.car.behavior.Car
import strategy_pattern.car.behavior.floating.brake.Breakable
import strategy_pattern.car.behavior.floating.brake.Unbraked
import strategy_pattern.car.behavior.floating.fuel.YesConsumerFuel
import strategy_pattern.car.behavior.floating.fuel.NoConsumerFuel
import strategy_pattern.car.behavior.floating.light_tech.Bowl
import strategy_pattern.car.behavior.floating.light_tech.LED
import strategy_pattern.car.behavior.floating.light_tech.Laser
import strategy_pattern.car.behavior.floating.light_tech.NoLight


/*---------------------------------------------------------------------------------------------------------------------*/

class PlasticCar : Car() {

    init {
        brakeBehavior = Unbraked()
        fuelBehavior = NoConsumerFuel()
        lightTechBehavior = NoLight()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} no start engin because this card is Plastic type!")
    }

}

/*---------------------------------------------------------------------------------------------------------------------*/

class BenzCar : Car() {

    init {
        brakeBehavior = Breakable()
        fuelBehavior = YesConsumerFuel("Hybrid / benzine")
        lightTechBehavior = LED()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} started engin by keyLess technology")
    }

}

/*---------------------------------------------------------------------------------------------------------------------*/

class SamandCar : Car() {

    init {
        brakeBehavior = Breakable()
        fuelBehavior = YesConsumerFuel("benzine / gas")
        lightTechBehavior = Bowl()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} started engin by shit key")
    }

}

/*---------------------------------------------------------------------------------------------------------------------*/

class ToyotaSupraCar : Car() {

    init {
        brakeBehavior = Breakable()
        fuelBehavior = YesConsumerFuel("benzine u5")
        lightTechBehavior = Laser()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} started engin by key")
    }

}

/*---------------------------------------------------------------------------------------------------------------------*/




fun main(){

     PlasticCar().apply {
         startEngin()
         doBrakeBehavior()
         doFuelBehavior(false)
         doLightTechBehavior()
    }

    println("********************************************")

    SamandCar().apply {
        startEngin()
        doBrakeBehavior()
        doFuelBehavior()
        doLightTechBehavior()
    }

    println("********************************************")

    BenzCar().apply {
        startEngin()
        doBrakeBehavior()
        doFuelBehavior()
        doLightTechBehavior()
    }

    println("********************************************")

    ToyotaSupraCar().apply {
        startEngin()
        doBrakeBehavior()
        doFuelBehavior()
        doLightTechBehavior()
    }


}