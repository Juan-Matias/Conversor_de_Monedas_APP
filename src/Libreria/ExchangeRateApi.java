package Libreria;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class ExchangeRateApi {
    private final String apiKey;

    public ExchangeRateApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public double getRate(String from, String to) throws IOException, InvalidCurrencyException {
        String endpoint = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, from);
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            Gson gson = new Gson();
            JsonObject response = gson.fromJson(reader, JsonObject.class);

            if (!response.get("result").getAsString().equals("success")) {
                throw new InvalidCurrencyException("Error: " + response.get("error-type").getAsString());
            }

            JsonObject rates = response.getAsJsonObject("conversion_rates");
            if (!rates.has(to)) {
                throw new InvalidCurrencyException("Moneda de destino no soportada.");
            }

            return rates.get(to).getAsDouble();
        }
    }
}
