# Conversor de Monedas

Este proyecto es una aplicación de consola escrita en Java que permite convertir entre diferentes monedas utilizando la API de ExchangeRate-API para obtener las tasas de conversión en tiempo real.

## Características
- Conversión entre múltiples monedas:
  - Dólar estadounidense (USD) a:
    - Peso argentino (ARS)
    - Real brasileño (BRL)
    - Peso colombiano (COP)
  - Peso argentino (ARS), Real brasileño (BRL) y Peso colombiano (COP) a Dólar estadounidense (USD).
- Tasas de cambio obtenidas en tiempo real mediante la API de ExchangeRate-API.
- Menú interactivo para seleccionar las conversiones y valores deseados.

## Requisitos

1. **Java Development Kit (JDK):**
   - Versión 8 o superior.

2. **Dependencia de JSON:**
   - Biblioteca `org.json` para procesar la respuesta JSON de la API.

   Si usas Gradle o Maven:
   - Gradle:
     ```gradle
     implementation 'org.json:json:20210307'
     ```
   - Maven:
     ```xml
     <dependency>
         <groupId>org.json</groupId>
         <artifactId>json</artifactId>
         <version>20210307</version>
     </dependency>
     ```
   Si trabajas con un proyecto simple sin gestor de dependencias, descarga el archivo JAR desde [Maven Repository](https://mvnrepository.com/artifact/org.json/json) y agrégalo al classpath.

3. **Clave API de ExchangeRate-API:**
   - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una clave API gratuita.
   - Reemplaza el valor de `API_KEY` en el código por tu clave.

## Cómo Ejecutar el Proyecto

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/tu_usuario/conversor-monedas.git
   cd conversor-monedas
   ```

2. **Compila el código:**
   ```bash
   javac -cp ".:libs/json-20210307.jar" ConversorApp.java
   ```

3. **Ejecuta la aplicación:**
   ```bash
   java -cp ".:libs/json-20210307.jar" ConversorApp
   ```

## Uso

1. Al ejecutar el programa, se mostrará un menú con las siguientes opciones:
   ```
   **********************************************
   Sea bienvenido/a al Conversor de Moneda :)
   **********************************************
   1) Dólar => Peso argentino
   2) Peso argentino => Dólar
   3) Dólar => Real brasileño
   4) Real brasileño => Dólar
   5) Dólar => Peso colombiano
   6) Peso colombiano => Dólar
   7) Salir
   ```

2. Selecciona una opción ingresando el número correspondiente.

3. Ingresa el valor que deseas convertir.

4. El programa mostrará el resultado de la conversión con base en la tasa de cambio obtenida de la API.

## Personalización

1. **Agregar nuevas monedas:**
   - Agrega nuevas opciones al menú en el método `mostrarMenu()`.
   - Define las conversiones en el método `realizarConversion()` utilizando los códigos ISO 4217 de las monedas.

2. **Cambiar la API:**
   - Si prefieres usar una API diferente, modifica el método `obtenerTasaDeCambio()` para adaptarlo al nuevo endpoint y formato de respuesta.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

---

¡Gracias por usar el Conversor de Monedas! Si tienes sugerencias o encuentras errores, no dudes en abrir un issue o enviar un pull request.

