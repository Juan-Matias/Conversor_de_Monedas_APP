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

