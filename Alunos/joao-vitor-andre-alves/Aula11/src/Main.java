import objects.WeatherPrinter;
import objects.WeatherRequest;
import objects.WeatherResponse;
import objects.WeatherService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String API_KEY = "U2CV7XVX5GSX4KHWLBNTLF365";
    private static final WeatherService service = new WeatherService(API_KEY);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===========================================");
            System.out.println("Seja bem vindo(a) - Consulta de Clima - Menu");
            System.out.println("============================================");
            System.out.println("1-  Consultar clima hoje");
            System.out.println("2 - Consultar clima por período");
            System.out.println("0 - Sair");
            System.out.println("===========================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    consultarClimaHoje();
                    break;
                case 2:
                    consultarClimaPorPeriodo();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void consultarClimaHoje() {
        System.out.print("\nDigite o nome da cidade: ");
        String cidade = scanner.nextLine().trim();

        if (cidade.isEmpty()) {
            System.out.println("Nome da cidade não pode ser vazio.");
            return;
        }

        System.out.println("Consultando...");
        WeatherRequest request = WeatherRequest.climaAtual(cidade);
        WeatherResponse response = service.consultar(request);
        WeatherPrinter.exibir(response);
    }

    public static void consultarClimaPorPeriodo() {
        System.out.print("\nDigite o nome da cidade: ");
        String cidade = scanner.nextLine().trim();

        if (cidade.isEmpty()) {
            System.out.println("Nome da cidade não pode ser vazio.");
            return;
        }

        System.out.print("Data inicial (YYYY-MM-DD): ");
        String dataInicio = scanner.nextLine().trim();

        System.out.print("Data final   (YYYY-MM-DD): ");
        String dataFim = scanner.nextLine().trim();

        if (dataInicio.isEmpty() || dataFim.isEmpty()) {
            System.out.println("As datas não podem ser vazias.");
            return;
        }

        System.out.println("Consultando...");
        WeatherRequest request = new WeatherRequest(
                cidade,
                dataInicio,
                dataFim,
                "metric",
                "pt",
                List.of("days"),
                List.of("datetime", "tempmax", "tempmin", "humidity", "conditions", "windspeed", "winddir", "precip"),
                "json");

        WeatherResponse response = service.consultar(request);
        WeatherPrinter.exibir(response);
    }
}
