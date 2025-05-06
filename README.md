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
