package strategy.car

import strategy.car.behavior.Car
import strategy.car.behavior.floating.brake.Brakeable
import strategy.car.behavior.floating.brake.Unbraked
import strategy.car.behavior.floating.fuel.YesConsumerFuel
import strategy.car.behavior.floating.fuel.NoConsumerFuel
import strategy.car.behavior.floating.light_tech.Bowl
import strategy.car.behavior.floating.light_tech.LED
import strategy.car.behavior.floating.light_tech.Laser
import strategy.car.behavior.floating.light_tech.NoLight


/******************************************************************************************************/

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

/******************************************************************************************************/

class BenzCar : Car() {

    init {
        brakeBehavior = Brakeable()
        fuelBehavior = YesConsumerFuel("Hybrid / benzine")
        lightTechBehavior = LED()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} started engin by keyLess technology")
    }

}

/******************************************************************************************************/

class SamandCar : Car() {

    init {
        brakeBehavior = Brakeable()
        fuelBehavior = YesConsumerFuel("benzine / gas")
        lightTechBehavior = Bowl()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} started engin by shit key")
    }

}

/******************************************************************************************************/

class ToyotaSupraCar : Car() {

    init {
        brakeBehavior = Brakeable()
        fuelBehavior = YesConsumerFuel("benzine u5")
        lightTechBehavior = Laser()
    }

    override fun startEngin() {
        println("${this::class.java.simpleName} started engin by key")
    }

}

/******************************************************************************************************/



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