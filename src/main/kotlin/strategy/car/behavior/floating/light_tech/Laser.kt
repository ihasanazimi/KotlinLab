package strategy.car.behavior.floating.light_tech

import strategy.car.behavior.fixed.LightTechBehavior

class Laser : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> Laser tech")
    }
}