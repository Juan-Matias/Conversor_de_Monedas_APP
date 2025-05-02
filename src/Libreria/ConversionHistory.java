package Libreria;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private final String filePath;
    private final Gson gson;

    public ConversionHistory(String filePath) {
        this.filePath = filePath;
        // Utilizamos GsonBuilder para habilitar el formato pretty
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Guardar las conversiones en el archivo
    public void saveConversion(ConversionResult result) {
        List<ConversionResult> history = loadHistory();
        history.add(result);
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(history, writer); // Guardar en formato pretty
        } catch (IOException e) {
            System.out.println("Error al guardar el historial de conversiones: " + e.getMessage());
        }
    }

    // Leer el historial desde el archivo
    public List<ConversionResult> loadHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Type type = new TypeToken<List<ConversionResult>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new ArrayList<>(); // Si no existe el archivo, devuelve una lista vacía
        }
    }
}
