import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ConversorApp {

    // Reemplaza con tu propia API Key de Exchange Rate
    private static final String API_KEY = "API_KEY";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingresa el valor que deseas convertir: ");
                double valor = scanner.nextDouble();
                realizarConversion(opcion, valor);
            } else if (opcion != 7) {
                System.out.println("Por favor, elige una opción válida.");
            }
        } while (opcion != 7);

        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n**********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda :)");
        System.out.println("**********************************************");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Salir");
        System.out.print("Elija una opción válida: ");
    }

    private static void realizarConversion(int opcion, double valor) {
        String from = "", to = "";

        // Definimos las conversiones según las opciones del menú
        switch (opcion) {
            case 1:
                from = "USD";
                to = "ARS"; // Peso argentino
                break;
            case 2:
                from = "ARS"; // Peso argentino
                to = "USD";
                break;
            case 3:
                from = "USD";
                to = "BRL"; // Real brasileño
                break;
            case 4:
                from = "BRL"; // Real brasileño
                to = "USD";
                break;
            case 5:
                from = "USD";
                to = "COP"; // Peso colombiano
                break;
            case 6:
                from = "COP"; // Peso colombiano
                to = "USD";
                break;
        }

        try {
            double tasa = obtenerTasaDeCambio(from, to);
            double resultado = valor * tasa;
            System.out.printf("El valor de %.2f %s corresponde a %.2f %s\n", valor, from, resultado, to);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la conversión: " + e.getMessage());
        }
    }

    private static double obtenerTasaDeCambio(String from, String to) throws Exception {
        String endpoint = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", API_KEY, from, to);
        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP response code: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse.getDouble("conversion_rate");
    }
}
