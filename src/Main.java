
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        GerenciadorContas gerenciadorContas = new GerenciadorContas(inputUser);
        boolean running = true;

        while (running) {
            gerenciadorContas.menu();
            int opcao = gerenciadorContas.validarEntradaInteira(inputUser);

            switch (opcao) {
                case 1 -> { // Conta Corrente
                    if (gerenciadorContas.getContasCorrente().isEmpty()) {
                        System.out.println("\nNenhuma conta corrente cadastrada!");
                        continue;
                    }
                    System.out.println("\nEscolha a conta pelo índice:");
                    gerenciadorContas.listarcontas();
                    int index = gerenciadorContas.validarEntradaInteira(inputUser);

                    if (index < 0 || index >= gerenciadorContas.getContasCorrente().size()) {
                        System.out.println("Índice inválido!");
                        continue;
                    }

                    gerenciadorContas.menuConta();
                    int opcaoConta = gerenciadorContas.validarEntradaInteira(inputUser);

                    switch (opcaoConta) {
                        case 1 -> {
                            System.out.print("\nDigite o valor do depósito: ");
                            double valor = validarEntradaDouble(inputUser);
                            gerenciadorContas.getContasCorrente().get(index).deposito(valor);
                        }
                        case 2 -> {
                            gerenciadorContas.getContasCorrente().get(index).consultarSaldo();
                        }
                        case 3 ->
                            running = false; // Sair do loop
                        default ->
                            System.out.println("Opção incorreta!");
                    }
                }
                case 2 -> { // Conta Poupança
                    if (gerenciadorContas.getContasPoupanca().isEmpty()) {
                        System.out.println("\nNenhuma conta poupança cadastrada!");
                        continue;
                    }
                    System.out.println("\nEscolha a conta pelo índice:");
                    gerenciadorContas.listarcontas();
                    int index = gerenciadorContas.validarEntradaInteira(inputUser);

                    if (index < 0 || index >= gerenciadorContas.getContasPoupanca().size()) {
                        System.out.println("Índice inválido!");
                        continue;
                    }

                    gerenciadorContas.menuConta();
                    int opcaoConta = gerenciadorContas.validarEntradaInteira(inputUser);

                    switch (opcaoConta) {
                        case 1 -> {
                            System.out.print("\nDigite o valor do depósito: ");
                            double valor = validarEntradaDouble(inputUser);
                            gerenciadorContas.getContasPoupanca().get(index).deposito(valor);
                        }
                        case 2 -> {
                            gerenciadorContas.getContasPoupanca().get(index).consultarSaldo();
                        }
                        case 3 ->
                            running = false;
                        default ->
                            System.out.println("Opção inválida!");
                    }
                }
                case 3 ->
                    gerenciadorContas.cadastroTitular();
                case 4 ->
                    gerenciadorContas.listarcontas();
                case 5 -> {
                    System.out.println("Obrigado por usar nosso banco. Até mais!");
                    running = false;
                }
                default ->
                    System.out.println("Opção inválida!");
            }
        }

        inputUser.close();
    }

    private static double validarEntradaDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número válido: ");
            }
        }
    }
}
