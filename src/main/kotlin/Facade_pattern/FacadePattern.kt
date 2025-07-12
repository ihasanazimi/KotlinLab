package Facade_pattern

// کلاس‌های زیرسیستم (فقط برای مثال، پیاده‌سازی کامل نیستند)
class Amplifier {
    fun on() { println("Amplifier on") }
    fun off() { println("Amplifier off") }
    fun setStreamingPlayer(player: StreamingPlayer) { println("Amplifier setting Streaming player") }
    fun setSurroundSound() { println("Amplifier surround sound on") }
    fun setVolume(volume: Int) { println("Amplifier volume set to $volume") }
}

class StreamingPlayer {
    fun on() { println("Streaming Player on") }
    fun off() { println("Streaming Player off") }
    fun play(movie: String) { println("Streaming Player playing \"$movie\"") }
    fun stop() { println("Streaming Player stopped") }
}

class Projector {
    fun on() { println("Projector on") }
    fun off() { println("Projector off") }
    fun wideScreenMode() { println("Projector in widescreen mode") }
}

class TheaterLights {
    fun on() { println("Theater Ceiling Lights on") }
    fun dim(level: Int) { println("Theater Ceiling Lights dimming to $level%") }
}

class Screen {
    fun up() { println("Theater Screen going up") }
    fun down() { println("Theater Screen going down") }
}

class PopcornPopper {
    fun on() { println("Popcorn Popper on") }
    fun off() { println("Popcorn Popper off") }
    fun pop() { println("Popcorn Popper popping popcorn!") }
}

// Facade: رابط ساده شده برای سیستم سینمای خانگی
class HomeTheaterFacade(
    private val amp: Amplifier,
    private val player: StreamingPlayer,
    private val projector: Projector,
    private val lights: TheaterLights,
    private val screen: Screen,
    private val popper: PopcornPopper
) {
    fun watchMovie(movie: String) {
        println("Get ready to watch a movie...")
        popper.on()
        popper.pop()
        lights.dim(10)
        screen.down()
        projector.on()
        projector.wideScreenMode()
        amp.on()
        amp.setStreamingPlayer(player)
        amp.setSurroundSound()
        amp.setVolume(5)
        player.on()
        player.play(movie)
    }

    fun endMovie() {
        println("Shutting movie theater down...")
        popper.off()
        lights.on()
        screen.up()
        projector.off()
        amp.off()
        player.stop()
        player.off()
    }
}

fun main() {
    // ایجاد اجزای زیرسیستم
    val amp = Amplifier()
    val player = StreamingPlayer()
    val projector = Projector()
    val lights = TheaterLights()
    val screen = Screen()
    val popper = PopcornPopper()

    // ایجاد Facade
    val homeTheater = HomeTheaterFacade(amp, player, projector, lights, screen, popper)

    // استفاده از Facade برای تماشای فیلم
    homeTheater.watchMovie("Raiders of the Lost Ark")

    println("\n--- Movie finished ---\n")

    // استفاده از Facade برای خاموش کردن سیستم
    homeTheater.endMovie()
}
