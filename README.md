# WEATHERAPP

A JavaFX application that displays real-time weather data using the OpenWeatherMap API.

### Features:
- Current weather conditions (temperature, humidity, wind speed)
- Weather condition descriptions
- Search any city worldwide
- Automatic refresh on search
- Error handling for invalid inputs
- Defaults to Moscow on start

## Requirements
- Java 20 JDK
- JavaFX 20 SDK
- OpenWeatherMap API key (free tier available [here](https://openweathermap.org/appid#signup))

## Installation
1. Get a repository.
2. Configure your API key:
   - Edit directly in `WeatherService.java`

## Building and Running

### Using Maven:
```
mvn clean javafx:run
```

### Manual Run:
```
java --module-path "path/to/javafx-sdk/lib" \
     --add-modules javafx.controls,javafx.fxml \
     -cp target/classes com.weatherapp.App
```