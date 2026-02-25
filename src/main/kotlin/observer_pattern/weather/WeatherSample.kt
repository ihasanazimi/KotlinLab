package observer_pattern.weather


interface WeatherObserver {
    fun updateWeather()
}
/*---------------------------------------------------------------------------------------------------------------------*/

interface WeatherSubject {
    fun registerWeatherObserver(o: WeatherObserver)
    fun removeWeatherObserver(o: WeatherObserver)
    fun notifyWeatherObservers()
}

/*---------------------------------------------------------------------------------------------------------------------*/
interface WeatherDisplayElement {
    fun display()
}


/*---------------------------------------------------------------------------------------------------------------------*/

class WeatherData : WeatherSubject {
    private val observersList: ArrayList<WeatherObserver> = ArrayList()
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {

    }

    override fun registerWeatherObserver(o: WeatherObserver) {
        observersList.add(o)
    }

    override fun removeWeatherObserver(o: WeatherObserver) {
        observersList.remove(o)
    }


    override fun notifyWeatherObservers() {
        for (observer in observersList) {
            observer.updateWeather()
        }
    }

    fun pushMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        notifyWeatherObservers() // notify new data`s
        println("\n")
    }

    fun getTemperature(): Float { return temperature }
    fun getHumidity(): Float { return humidity }
    fun getPressure(): Float { return pressure }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class CurrentConditionsMonitor(private val weatherData: WeatherData) : WeatherObserver, WeatherDisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        weatherData.registerWeatherObserver(this)
    }

    override fun updateWeather() {
        this.temperature = weatherData.getTemperature()
        this.humidity = weatherData.getHumidity()
        this.pressure = weatherData.getPressure()
        display()
    }

    override fun display() {
        println("${this::class.java.simpleName}  ->  Current conditions: $temperature F degrees and $humidity % humidity and pressure is $pressure")
    }
}



/*---------------------------------------------------------------------------------------------------------------------*/


class ForecastMonitor(private val weatherData: WeatherData) : WeatherObserver , WeatherDisplayElement {

    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        weatherData.registerWeatherObserver(this)
    }


    override fun updateWeather() {
        this.temperature = weatherData.getTemperature()
        this.humidity = weatherData.getHumidity()
        this.pressure = weatherData.getPressure()
        display()
    }

    override fun display() {
        println("${this::class.java.simpleName}  ->  Current conditions: $temperature F degrees and $humidity % humidity and pressure is $pressure")
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/


class StatisticsMonitor(private val weatherData: WeatherData) : WeatherObserver , WeatherDisplayElement {

    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        weatherData.registerWeatherObserver(this)
    }


    override fun updateWeather() {
        this.temperature = weatherData.getTemperature()
        this.humidity = weatherData.getHumidity()
        this.pressure = weatherData.getPressure()
        display()
    }

    override fun display() {
        println("${this::class.java.simpleName}  ->  Current conditions: $temperature F degrees and $humidity % humidity and pressure is $pressure")
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/

fun main() {

    /** this is a SUBJECT */
    val weatherData = WeatherData()

    /** Creating Display and connect subject to it. */
    val currentDisplay = CurrentConditionsMonitor(weatherData)
    val statisticsDisplay = StatisticsMonitor(weatherData)
    val forecastDisplay = ForecastMonitor(weatherData)
    /** simulate measured values */
    weatherData.pushMeasurements(80f, 65f, 30.4f)
    weatherData.pushMeasurements(82f, 70f, 29.2f)
    weatherData.pushMeasurements(78f, 90f, 29.2f)


    /** add or remove some observers */
    weatherData.removeWeatherObserver(currentDisplay)
    weatherData.pushMeasurements(70f, 60f, 30.0f)
}