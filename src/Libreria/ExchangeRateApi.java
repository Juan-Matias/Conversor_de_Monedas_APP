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

    // Constructor: Inicializa la API con la clave proporcionada.
    public ExchangeRateApi(String apiKey) {
        this.apiKey = apiKey;
    }

    // Obtiene la tasa de cambio entre dos monedas.
    // Lanza InvalidCurrencyException si hay un error con las monedas o si la API falla.
    public double getRate(String from, String to) throws IOException, InvalidCurrencyException {
        String endpoint = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, from);
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            Gson gson = new Gson();
            JsonObject response = gson.fromJson(reader, JsonObject.class);

            // Verifica si la respuesta es exitosa
            if (!response.get("result").getAsString().equals("success")) {
                throw new InvalidCurrencyException("Error: " + response.get("error-type").getAsString());
            }

            JsonObject rates = response.getAsJsonObject("conversion_rates");

            // Verifica si la moneda de destino está soportada
            if (!rates.has(to)) {
                throw new InvalidCurrencyException("Moneda de destino no soportada.");
            }

            return rates.get(to).getAsDouble(); // Devuelve la tasa de cambio
        }
    }
}
