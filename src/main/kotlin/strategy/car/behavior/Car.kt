package strategy.car.behavior

import strategy.car.behavior.fixed.BrakeBehavior
import strategy.car.behavior.fixed.FuelBehavior
import strategy.car.behavior.fixed.LightTechBehavior

abstract class Car {

    var brakeBehavior : BrakeBehavior ?= null
    var fuelBehavior : FuelBehavior?= null
    var lightTechBehavior : LightTechBehavior?= null


    fun wheel(){
        println("all cars movement by wheel.")
    }

    abstract fun startEngin()


    fun doBrakeBehavior(){
        brakeBehavior?.brake()
    }


    fun doFuelBehavior(isRealCard : Boolean = true){
        if (isRealCard) fuelBehavior?.consumerFuel()
        else fuelBehavior?.noFuel()
    }


    fun doLightTechBehavior(){
        lightTechBehavior?.lightTech()
    }


    fun replaceBrakeBehavior(brakeBehavior: BrakeBehavior){
        this.brakeBehavior = brakeBehavior
    }


    fun replaceFuelBehavior(fuelBehavior: FuelBehavior){
        this.fuelBehavior = fuelBehavior
    }

    fun replaceLightTechBehavior(lightTechBehavior: LightTechBehavior){
        this.lightTechBehavior = lightTechBehavior
    }


}