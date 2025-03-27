package com.weatherapp;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherService {
    private static final String API_KEY = "key"; // Replace with your actual API key
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherData getWeatherData(String city) throws Exception {
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String url = String.format("%s?q=%s&appid=%s&units=metric&lang=en", 
                                 BASE_URL, encodedCity, API_KEY);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Failed to get weather for " + city + 
                             ". Response: " + response.statusCode() + " - " + response.body());
        }

        return parseWeatherData(response.body());
    }

    private WeatherData parseWeatherData(String json) {
        try {
            String city = json.split("\"name\":\"")[1].split("\"")[0];
            double temp = Double.parseDouble(json.split("\"temp\":")[1].split(",")[0]);
            double humidity = Double.parseDouble(json.split("\"humidity\":")[1].split(",")[0]);
            double windSpeed = Double.parseDouble(json.split("\"speed\":")[1].split(",")[0]);
            String conditions = json.split("\"description\":\"")[1].split("\"")[0];

            return new WeatherData(city, temp, humidity, windSpeed, conditions);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse weather data: " + e.getMessage(), e);
        }
    }
}