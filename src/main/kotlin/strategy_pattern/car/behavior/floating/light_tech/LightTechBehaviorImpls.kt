package strategy_pattern.car.behavior.floating.light_tech

import strategy_pattern.car.behavior.fixed.LightTechBehavior

/*---------------------------------------------------------------------------------------------------------------------*/


class Bowl : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> Bowl tech")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


class NoLight : LightTechBehavior{
    override fun lightTech() {
        println("no light")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


class LED : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> LED tech")
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/


class Laser : LightTechBehavior {
    override fun lightTech() {
        println("Lighting by -> Laser tech")
    }
}