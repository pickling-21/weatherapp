package com.weatherapp;

public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final double windSpeed;
    private final String conditions;

    public WeatherData(String city, double temperature, double humidity, 
                     double windSpeed, String conditions) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.conditions = conditions;
    }

    public String getCity() { return city; }
    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public double getWindSpeed() { return windSpeed; }
    public String getConditions() { return conditions; }
}