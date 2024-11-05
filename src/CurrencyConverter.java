import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "c692102fec547806c3c507df"; // Reemplaza con tu clave de API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú principal
        System.out.println("Bienvenido al Convertidor de Divisas");
        System.out.println("Seleccione la divisa de origen:");
        System.out.println("1. USD - Dólar estadounidense");
        System.out.println("2. EUR - Euro");
        System.out.println("3. COP - Peso colombiano");
        System.out.println("4. MXN - Peso mexicano");
        System.out.print("Seleccione una opción: ");
        int fromOption = scanner.nextInt();

        System.out.println("Seleccione la divisa de destino:");
        System.out.println("1. USD - Dólar estadounidense");
        System.out.println("2. EUR - Euro");
        System.out.println("3. COP - Peso colombiano");
        System.out.println("4. MXN - Peso mexicano");
        System.out.print("Seleccione una opción: ");
        int toOption = scanner.nextInt();

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        // Obtener los códigos de moneda basados en las opciones
        String fromCurrency = getCurrencyCode(fromOption);
        String toCurrency = getCurrencyCode(toOption);

        if (fromCurrency == null || toCurrency == null) {
            System.out.println("Opción inválida.");
            return;
        }

        // Realizar la conversión
        convertCurrency(fromCurrency, toCurrency, amount);
    }

    private static String getCurrencyCode(int option) {
        return switch (option) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "COP";
            case 4 -> "MXN";
            default -> null;
        };
    }

    private static void convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = BASE_URL + fromCurrency;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                double exchangeRate = getExchangeRate(responseBody, toCurrency);

                if (exchangeRate != -1) {
                    double convertedAmount = amount * exchangeRate;
                    System.out.printf("%.2f %s son %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
                } else {
                    System.out.println("No se encontró la tasa de cambio para la divisa de destino.");
                }
            } else {
                System.out.println("Error en la solicitud a la API. Código de estado: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double getExchangeRate(String responseBody, String toCurrency) {
        try {
            String search = "\"" + toCurrency + "\":";
            int index = responseBody.indexOf(search);

            if (index == -1) return -1;

            int start = index + search.length();
            int end = responseBody.indexOf(",", start);
            if (end == -1) end = responseBody.indexOf("}", start);

            String rateStr = responseBody.substring(start, end).trim();
            return Double.parseDouble(rateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
