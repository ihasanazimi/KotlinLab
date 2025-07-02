package observer.weather.observers

import observer.weather.data.DisplayElement
import observer.weather.data.WeatherObserver
import observer.weather.data.WeatherData

class ForecastMonitor(private val weatherData: WeatherData) : WeatherObserver , DisplayElement {

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