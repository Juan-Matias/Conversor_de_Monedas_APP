package Libreria;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {

    // Atributos
    private final String filePath;
    private final Gson gson;

    // Constructor
    public ConversionHistory(String filePath) {
        this.filePath = filePath;
        this.gson = new GsonBuilder().setPrettyPrinting().create(); // Configura Gson para salida legible
    }

    // Guarda una nueva conversión en el archivo JSON
    public void saveConversion(ConversionResult result) throws IOException {
        if (result == null) {
            throw new IllegalArgumentException("El resultado de conversión no puede ser nulo.");
        }

        List<ConversionResult> history = loadHistory(); // Carga historial actual
        history.add(result); // Añade el nuevo resultado

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(history, writer); // Guarda historial actualizado
        } catch (IOException e) {
            throw new IOException("Error al guardar el historial: " + e.getMessage(), e);
        }
    }

    // Carga el historial desde el archivo JSON, o crea uno nuevo si no existe
    public List<ConversionResult> loadHistory() {
        File file = new File(filePath);

        // Si el archivo no existe, lo crea
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
            return new ArrayList<>(); // Retorna lista vacía si no hay historial
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Type type = new TypeToken<List<ConversionResult>>() {}.getType();
            return gson.fromJson(reader, type); // Deserializa historial
        } catch (IOException e) {
            System.out.println("Error al cargar el historial: " + e.getMessage());
            return new ArrayList<>(); // Retorna lista vacía si ocurre un error
        }
    }
}
