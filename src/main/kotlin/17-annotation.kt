
@Smart
class PhoneClass{
    var display : String = "landscape"
}

@Target(AnnotationTarget.CLASS , AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Smart()


fun main(){

    val phoneReflectionObj = PhoneClass::class
    println(phoneReflectionObj.annotations)

}
