package strategy_pattern.car.behavior.floating.light_tech

import strategy_pattern.car.behavior.fixed.LightTechBehavior

class LED : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> LED tech")
    }
}