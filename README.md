# 💱 Conversor de Moneda con API

![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=java)
![License](https://img.shields.io/badge/License-MIT-green)
![API](https://img.shields.io/badge/API-ExchangeRate--API-orange)

<div align="center">
  <img src="https://raw.githubusercontent.com/Juan-Matias/Conversor_de_Monedas_APP/main/src/Resource/currency-exchange.svg" width="200" alt="Icono conversor">
</div>

## 📝 Descripción
Un **conversor de monedas** moderno desarrollado en Java que utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para conversiones en tiempo real entre las principales monedas de América Latina.

## ✨ Características principales
| Funcionalidad | Monedas | Estado |
|--------------|---------|--------|
| Conversión básica | USD ↔ ARS | ✅ |
| Conversión básica | USD ↔ BRL | ✅ |
| Conversión básica | USD ↔ COP | ✅ |
| Historial de conversiones | JSON | ✅ |
| Manejo de errores | Custom Exceptions | ✅ |

## 🏗 Estructura del proyecto

```mermaid
graph TD
    A[Main.java] --> B[CurrencyConverter]
    B --> C[ExchangeRateApi]
    B --> D[ConversionHistory]
    C --> E[API Externa]
    D --> F[conversion_history.json]
    B --> G[InvalidCurrencyException]
📊 Diagrama de Clases
Diagrama UML

🛠 Detalles de Implementación
🔧 Componentes principales
CurrencyConverter: Motor principal de conversión

java
public ConversionResult convert(double amount, String from, String to) {
  // Lógica de conversión
}
ExchangeRateApi: Cliente REST para la API

java
public double getExchangeRate(String from, String to) throws IOException {
  // Consumo de API
}
📂 Persistencia de datos
El historial se guarda en formato JSON:

json
[
  {
    "from": "USD",
    "to": "ARS",
    "rate": 210.5,
    "result": 21050.0
  }
]
🚀 Cómo usar
Ejecuta la aplicación:

bash
java -jar ConversorDeMoneda.jar
Selecciona una opción del menú:

1. USD → ARS
2. ARS → USD
3. USD → BRL
...
Ingresa el monto a convertir

📦 Requisitos e instalación
Prerrequisitos
JDK 17+

Maven 3.6+

API Key de ExchangeRate-API

Instalación
bash
git clone https://github.com/Juan-Matias/Conversor_de_Monedas_APP.git
cd Conversor_de_Monedas_APP
mvn clean install
📜 Licencia
Este proyecto está bajo licencia MIT. Ver archivo LICENSE para más detalles.

<div align="center"> Hecho con ❤️ por Juan Matías | 2023 </div> ```
