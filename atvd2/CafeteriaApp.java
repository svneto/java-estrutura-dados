import java.util.Scanner;

public class CafeteriaApp {
    public static void main(String[] args) {
        GerenciadorDePedidos gerenciador = new GerenciadorDePedidos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar novo pedido");
            System.out.println("2. Processar próximo pedido");
            System.out.println("3. Visualizar pedidos");
            System.out.println("4. Remover pedido cancelado");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String clienteNome = scanner.nextLine();
                    System.out.print("É VIP? (true/false): ");
                    boolean isVIP = scanner.nextBoolean();
                    gerenciador.adicionarNovoPedido(clienteNome, isVIP);
                    break;
                case 2:
                    gerenciador.processarProximoPedido();
                    break;
                case 3:
                    gerenciador.visualizarPedidos();
                    break;
                case 4:
                    System.out.print("ID do pedido a ser cancelado: ");
                    int id = scanner.nextInt();
                    gerenciador.removerPedido(id);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
