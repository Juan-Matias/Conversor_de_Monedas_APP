package Aplicacion;

import Libreria.CurrencyConverter;
import Libreria.ConversionResult;
import Libreria.ConversionHistory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String apiKey = "1036aba11f612b530dd9ba4e"; // API Key real
        CurrencyConverter converter = new CurrencyConverter(apiKey);
        ConversionHistory history = new ConversionHistory("conversion_history.json");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = leerOpcion(scanner);
            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            String from = "", to = "";
            switch (opcion) {
                case 1 -> { from = "USD"; to = "ARS"; }
                case 2 -> { from = "ARS"; to = "USD"; }
                case 3 -> { from = "USD"; to = "BRL"; }
                case 4 -> { from = "BRL"; to = "USD"; }
                case 5 -> { from = "USD"; to = "COP"; }
                case 6 -> { from = "COP"; to = "USD"; }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            double amount = leerMonto(scanner);
            ConversionResult result = converter.convert(from, to, amount);
            if (result != null) {
                System.out.println(result);
                history.saveConversion(result); // Guardar la conversión en el archivo
            }

            mostrarHistorial(history.loadHistory()); // Mostrar historial de conversiones
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                ******************************************************************
                Sea bienvenido/a al Conversor de Moneda =]

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ******************************************************************
                """);
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        while (opcion < 1 || opcion > 7) {
            if (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Ingrese un número entre 1 y 7.");
                scanner.next(); // Limpiar buffer
            } else {
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción fuera de rango. Elija una opción válida.");
                }
            }
        }
        return opcion;
    }

    private static double leerMonto(Scanner scanner) {
        double amount = 0;
        while (true) {
            System.out.print("Ingrese el monto a convertir: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar buffer
            } else {
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("El monto debe ser mayor a cero.");
                } else {
                    break;
                }
            }
        }
        return amount;
    }

    // Mostrar historial de conversiones
    private static void mostrarHistorial(List<ConversionResult> history) {
        if (history.isEmpty()) {
            System.out.println("No hay conversiones previas.");
        } else {
            System.out.println("\nHistorial de conversiones:");
            for (ConversionResult result : history) {
                System.out.println(result);
            }
        }
    }
}
