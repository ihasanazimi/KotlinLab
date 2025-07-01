package strategy.car.behavior.floating.light_tech

import strategy.car.behavior.fixed.LightTechBehavior

class Bowl : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> Bowl tech")
    }
}