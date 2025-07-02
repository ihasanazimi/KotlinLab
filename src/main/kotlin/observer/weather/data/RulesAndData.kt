package observer.weather.data


interface WeatherObserver {
    fun updateWeather()
}


interface Subject {
    fun registerWeatherObserver(o: WeatherObserver)
    fun removeWeatherObserver(o: WeatherObserver)
    fun notifyWeatherObservers()
}


interface DisplayElement {
    fun display()
}


/***************************************************************************************************/


class WeatherData : Subject {
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