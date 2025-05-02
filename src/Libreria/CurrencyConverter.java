package Libreria;

import java.io.IOException;

public class CurrencyConverter {
    private final ExchangeRateApi api;

    public CurrencyConverter(String apiKey) {
        this.api = new ExchangeRateApi(apiKey);
    }

    public ConversionResult convert(String from, String to, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        try {
            double rate = api.getRate(from, to);
            double convertedAmount = amount * rate;
            return new ConversionResult(from, to, rate, convertedAmount);
        } catch (InvalidCurrencyException | IOException e) {
            System.out.println("Error al obtener tasa de cambio: " + e.getMessage());
            return null;
        }
    }
}
