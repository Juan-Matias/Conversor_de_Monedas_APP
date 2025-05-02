package Libreria;

public record ConversionResult(String fromCurrency,
                               String toCurrency,
                               double rate,
                               double convertedAmount) {
    @Override
    public String toString() {
        return String.format("Convertido %.2f %s a %.2f %s con tasa de cambio %.4f",
                convertedAmount, toCurrency, convertedAmount * rate, fromCurrency, rate);
    }
}
