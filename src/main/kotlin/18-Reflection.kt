import kotlin.reflect.full.*
import kotlin.reflect.full.primaryConstructor


class Person(val name: String, val age: Int)


fun main() {
    val kClass = Person::class
    val constructor = kClass.primaryConstructor
    val personInstance = constructor?.call("Alice", 25)
    println(personInstance?.name)
}




