package Libreria;

import java.io.IOException;

public class CurrencyConverter {
    private final ExchangeRateApi api;

    // Constructor: Inicializa el conversor con la clave de la API.
    public CurrencyConverter(String apiKey) {
        this.api = new ExchangeRateApi(apiKey);
    }

    // Convierte una cantidad de una moneda a otra.
    // Lanza una excepción si el monto es menor o igual a cero.
    public ConversionResult convert(String from, String to, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        try {
            // Obtiene la tasa de cambio y realiza la conversión
            double rate = api.getRate(from, to);
            double convertedAmount = amount * rate;
            return new ConversionResult(from, to, rate, convertedAmount);
        } catch (InvalidCurrencyException | IOException e) {
            // Captura errores en la obtención de la tasa de cambio
            System.out.println("Error al obtener tasa de cambio: " + e.getMessage());
            return null; // Retorna null en caso de error
        }
    }
}
