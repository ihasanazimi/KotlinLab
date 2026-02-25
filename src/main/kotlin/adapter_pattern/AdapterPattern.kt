package adapter_pattern

/*---------------------------------------------------------------------------------------------------------------------*/


interface Duck {
    fun quack()
    fun fly()
}

/*---------------------------------------------------------------------------------------------------------------------*/


class MallardDuck : Duck {
    override fun quack() {
        println("Quack")
    }
    override fun fly() {
        println("I'm flying")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


interface Turkey {
    fun gobble()
    fun fly()
}

/*---------------------------------------------------------------------------------------------------------------------*/


class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }
    override fun fly() {
        println("I'm flying a short distance")
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


class TurkeyAdapter(private val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 0 until 5) {
            turkey.fly()
        }
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

fun main() {
    val duck = MallardDuck()
    val turkey = WildTurkey()
    val turkeyAdapter = TurkeyAdapter(turkey)

    println("The Turkey says...")
    turkey.gobble()
    turkey.fly()

    println("\nThe Duck says...")
    testDuck(duck)

    println("\nThe TurkeyAdapter says (acting like a Duck)...")
    testDuck(turkeyAdapter)
}

fun testDuck(duck: Duck) {
    duck.quack()
    duck.fly()
}