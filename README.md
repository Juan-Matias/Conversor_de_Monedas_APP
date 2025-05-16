# 💱 Conversor de Moneda con API

![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=java)
![License](https://img.shields.io/badge/License-MIT-green)
![API](https://img.shields.io/badge/API-ExchangeRate--API-orange)

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
```
todo-list/ ├── index.html ├── style.css └── script.js
``

```mermaid
graph TD
    A[Main.java] --> B[CurrencyConverter]
    B --> C[ExchangeRateApi]
    B --> D[ConversionHistory]
    C --> E[API Externa]
    D --> F[conversion_history.json]
    B --> G[InvalidCurrencyException]

```

## 📊 Diagrama de Clases

```mermaid
classDiagram
    class Main {
        +main(args: String[]): void
    }

    class CurrencyConverter {
        +convert(from: String, to: String, amount: double): ConversionResult
    }

    class ExchangeRateApi {
        +getRate(from: String, to: String): double
    }

    class ConversionResult {
        <<record>>
        +from: String
        +to: String
        +rate: double
        +result: double
    }

    class ConversionHistory {
        +saveConversion(result: ConversionResult): void
        +loadHistory(): List~ConversionResult~
    }

    class InvalidCurrencyException {
        +InvalidCurrencyException(message: String)
    }

    %% Relaciones
    Main --> CurrencyConverter : utiliza
    CurrencyConverter --> ExchangeRateApi : consulta tasa
    CurrencyConverter --> ConversionResult : devuelve
    CurrencyConverter --> ConversionHistory : guarda
    ExchangeRateApi --> InvalidCurrencyException : lanza
```

## 🛠 Detalles de Implementación

### 🔧 Componentes principales

**CurrencyConverter**: Motor principal de conversión  
```java
public ConversionResult convert(double amount, String from, String to) {
  // Lógica de conversión
}
```

ExchangeRateApi: Cliente REST para la API

```java
public double getExchangeRate(String from, String to) throws IOException {
  // Consumo de API
}
```

## 📂 Persistencia de datos
El historial se guarda en formato JSON:

```json
[
  {
    "from": "USD",
    "to": "ARS",
    "rate": 210.5,
    "result": 21050.0
  }
]
```

## 🚀 Cómo usar
Ejecuta la aplicación:

```bash
java -jar ConversorDeMoneda.jar
```

Selecciona una opción del menú:
```bash
1. USD → ARS
2. ARS → USD
3. USD → BRL
Ingresa el monto a convertir
````
## 📦 Requisitos e instalación
Prerrequisitos
JDK 17+

Maven 3.6+

API Key de ExchangeRate-API

Instalación
```bash
git clone https://github.com/Juan-Matias/Conversor_de_Monedas_APP.git
cd Conversor_de_Monedas_APP
```

mvn clean install
📜 Licencia
Este proyecto está bajo licencia MIT. Ver archivo LICENSE para más detalles.

<div align="center"> Hecho con ❤️ por Juan Matías | 2023 </div> 
