package strategy_pattern.duck.behaviors.floating.quack

import strategy_pattern.duck.behaviors.fixed.QuackBehavior

// پیاده‌سازی‌های مختلف کواک
class Quack : QuackBehavior {
    override fun quack() {
        println("Quack!") // کواک!
    }
}