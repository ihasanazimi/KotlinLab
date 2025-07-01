package strategy.duck.behaviors.floating.quack

import strategy.duck.behaviors.fixed.QuackBehavior

// پیاده‌سازی‌های مختلف کواک
class Quack : QuackBehavior {
    override fun quack() {
        println("Quack!") // کواک!
    }
}