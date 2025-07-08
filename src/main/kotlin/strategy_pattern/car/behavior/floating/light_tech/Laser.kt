package strategy_pattern.car.behavior.floating.light_tech

import strategy_pattern.car.behavior.fixed.LightTechBehavior

class Laser : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> Laser tech")
    }
}