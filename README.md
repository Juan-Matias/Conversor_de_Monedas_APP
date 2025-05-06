# 💰Conversor de Moneda

## Descripción
Este es un **conversor de monedas** simple que utiliza la API de **ExchangeRate-API** para realizar conversiones entre varias monedas, como Dólar, Peso argentino, Real brasileño y Peso colombiano. El proyecto está desarrollado en **Java** y permite realizar conversiones desde la consola de manera interactiva.

## Funcionalidades
- Conversión de Dólar a Peso argentino
- Conversión de Peso argentino a Dólar
- Conversión de Dólar a Real brasileño
- Conversión de Real brasileño a Dólar
- Conversión de Dólar a Peso colombiano
- Conversión de Peso colombiano a Dólar

## Estructura del Proyecto

```plaintext
ConversorDeMoneda/
├── Aplicacion
│   └── Main.java                    <-- Menú principal (consola)
├── Libreria
│   ├── CurrencyConverter.java       <-- Lógica para convertir monedas
│   ├── ExchangeRateApi.java        <-- Llamada a la API REST
│   ├── ConversionResult.java       <-- Record con resultado (from, to, rate, result)
│   ├── ConversionHistory.java      <-- Historial de conversiones
│   └── InvalidCurrencyException.java <-- Excepción para monedas no válidas
└── resources
    └── diagram.png                 <-- Diagrama de clases (en formato PNG)
```
## Diagrama de Clases
![Diagrama UML](https://github.com/Juan-Matias/Conversor_de_Monedas_APP/blob/fdf3869fe8262bca14ee16d82aa3a31251c99e22/src/Resource/Diagrama_de_clases.png)

## Detalles de Implementación
- **CurrencyConverter**: Esta clase contiene la lógica para realizar las conversiones entre monedas. Se conecta a la API ExchangeRate-API para obtener las tasas de cambio.
- **ExchangeRateApi**: Se encarga de la interacción con la API REST que proporciona las tasas de cambio entre monedas.
- **ConversionResult**: Es una clase de tipo record que guarda el resultado de la conversión, incluyendo las monedas involucradas, la tasa de cambio y el monto convertido.
- **ConversionHistory**: Permite guardar y cargar el historial de conversiones realizadas. Los resultados se almacenan en un archivo JSON para mantener un registro persistente.
- **InvalidCurrencyException**: Excepción personalizada que se lanza si se intenta realizar una conversión con una moneda no válida o si la API devuelve un error.

## Uso
- Al ejecutar la aplicación, el usuario verá un menú interactivo desde la consola para seleccionar la conversión que desea realizar.
- El usuario ingresa el monto a convertir, y el sistema devuelve el resultado de la conversión.
- El historial de conversiones se guarda en un archivo `conversion_history.json` para ser consultado en futuras ejecuciones.

## Requisitos
- Java 11 o superior.
- Internet para obtener las tasas de cambio desde la API.
- API Key para acceder a ExchangeRate-API (puedes obtenerla [aquí](https://www.exchangerate-api.com/)).

## Instalación
1. Clona este repositorio:
```bash
git clone https://github.com/Juan-Matias/Conversor_de_Monedas_APP.git
