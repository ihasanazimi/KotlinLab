package strategy.car.behavior.floating.light_tech

import strategy.car.behavior.fixed.LightTechBehavior

class LED : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> LED tech")
    }
}