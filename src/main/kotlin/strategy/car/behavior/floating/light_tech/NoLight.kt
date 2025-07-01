package strategy.car.behavior.floating.light_tech

import strategy.car.behavior.fixed.LightTechBehavior

class NoLight : LightTechBehavior{
    override fun lightTech() {
        println("no light")
    }
}