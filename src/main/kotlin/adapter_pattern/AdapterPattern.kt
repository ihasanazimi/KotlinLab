package adapter_pattern



/*


اجزای اصلی الگوی Adapter:

Target (هدف): این همون رابطی هست که کلاینت (سیستم تو) انتظار داره باهاش کار کنه.

Client (کلاینت): این بخشی از کده که می‌خواد از یه شیء استفاده کنه، اما فقط رابط Target رو می‌شناسه.

Adaptee (آداپتی): این همون کلاسی هست که رابطش ناسازگاره و ما می‌خوایم ازش استفاده کنیم.

Adapter (آداپتور): این کلاس، رابط Target رو پیاده‌سازی می‌کنه و در داخل خودش یه مرجع به Adaptee داره.
 وقتی کلاینت متدی رو روی Adapter صدا می‌زنه، Adapter اون درخواست رو به متد مناسب روی Adaptee تبدیل می‌کنه و محول می‌کنه.

 */


// واسط Target: چیزی که کلاینت (سیستم ما) انتظار دارد
interface Duck {
    fun quack()
    fun fly()
}

// پیاده‌سازی Duck (برای تست)
class MallardDuck : Duck {
    override fun quack() {
        println("Quack")
    }
    override fun fly() {
        println("I'm flying")
    }
}

// Adaptee: کلاسی که رابطش ناسازگار است
interface Turkey {
    fun gobble() // بوقلمون غبغب می‌کند
    fun fly()    // بوقلمون پرواز کوتاه می‌کند
}

// پیاده‌سازی Turkey (برای تست)
class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }
    override fun fly() {
        println("I'm flying a short distance")
    }
}

// Adapter: این کلاس رابط Duck را پیاده‌سازی می‌کند و Turkey را تطبیق می‌دهد
class TurkeyAdapter(private val turkey: Turkey) : Duck { // Adapter رابط Duck را پیاده‌سازی می‌کند
    override fun quack() {
        turkey.gobble() // وقتی Duck.quack() صدا زده می‌شود، به Turkey.gobble() تبدیل می‌شود
    }

    override fun fly() {
        // بوقلمون‌ها پرواز کوتاه می‌کنند، پس برای شبیه‌سازی پرواز اردک، چند بار پرواز بوقلمون را صدا می‌زنیم
        for (i in 0 until 5) {
            turkey.fly()
        }
    }
}

fun main() {
    val duck = MallardDuck()
    val turkey = WildTurkey()
    val turkeyAdapter = TurkeyAdapter(turkey) // بوقلمون را به اردک تبدیل می‌کنیم

    println("The Turkey says...")
    turkey.gobble()
    turkey.fly()

    println("\nThe Duck says...")
    testDuck(duck) // تست اردک واقعی

    println("\nThe TurkeyAdapter says (acting like a Duck)...")
    testDuck(turkeyAdapter) // تست بوقلمون که مثل اردک رفتار می‌کند
}

// متدی که انتظار یک Duck را دارد
fun testDuck(duck: Duck) {
    duck.quack()
    duck.fly()
}