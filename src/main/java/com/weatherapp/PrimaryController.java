package com.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML private TextField cityInput;
    @FXML private Button searchButton;
    @FXML private Label cityLabel;
    @FXML private Label tempLabel;
    @FXML private Label humidityLabel;
    @FXML private Label windLabel;
    @FXML private Label conditionsLabel;
    @FXML private Label errorLabel;

    private final WeatherService weatherService = new WeatherService();

    @FXML
    public void initialize() {
        // Initialize with Moscow by default
        cityInput.setText("Moscow");
        
        // Set up the search button action
        searchButton.setOnAction(event -> handleSearch());
    }

    @FXML
    private void handleSearch() {
        String city = cityInput.getText().trim();
        if (city.isEmpty()) {
            showError("Please enter a city name");
            return;
        }

        try {
            WeatherData data = weatherService.getWeatherData(city);
            updateDisplay(data);
            errorLabel.setText("");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private void updateDisplay(WeatherData data) {
        cityLabel.setText("City: " + data.getCity());
        tempLabel.setText(String.format("Temperature: %.1f°C", data.getTemperature()));
        humidityLabel.setText(String.format("Humidity: %.0f%%", data.getHumidity()));
        windLabel.setText(String.format("Wind Speed: %.1f m/s", data.getWindSpeed()));
        conditionsLabel.setText("Conditions: " + data.getConditions());
    }

    private void showError(String message) {
        errorLabel.setText("Error: " + message);
    }
}