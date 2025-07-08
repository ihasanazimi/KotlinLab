package strategy_pattern.car.behavior.floating.light_tech

import strategy_pattern.car.behavior.fixed.LightTechBehavior

class NoLight : LightTechBehavior{
    override fun lightTech() {
        println("no light")
    }
}