package observer.weather

import observer.weather.data.WeatherData
import observer.weather.observers.CurrentConditionsMonitor
import observer.weather.observers.ForecastMonitor
import observer.weather.observers.StatisticsMonitor

fun main() {

    /** this is a SUBJECT */
    val weatherData = WeatherData()

    /** Creating Display and connect subject to it. */
    val currentDisplay = CurrentConditionsMonitor(weatherData)
    val statisticsDisplay = StatisticsMonitor(weatherData)
    val forecastDisplay = ForecastMonitor(weatherData)

    /** simulate measured values */
    weatherData.setMeasurements(80f, 65f, 30.4f)
    weatherData.setMeasurements(82f, 70f, 29.2f)
    weatherData.setMeasurements(78f, 90f, 29.2f)


    /** add or remove some observers */
    weatherData.removeWeatherObserver(currentDisplay)
    weatherData.setMeasurements(70f, 60f, 30.0f)
}