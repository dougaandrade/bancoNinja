
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        GerenciadorContas gerenciadorContas = new GerenciadorContas(inputUser);

        while (true) {
            gerenciadorContas.menu();
            int opcao = gerenciadorContas.validarEntradaInteira(inputUser);

            switch (opcao) {
                case 1 -> {
                    if (gerenciadorContas.getContasCorrente().isEmpty()) {
                        System.out.println("\nNenhuma conta corrente cadastrada!");
                        break;
                    }
                    gerenciadorContas.menuConta();
                    int opcaoConta = gerenciadorContas.validarEntradaInteira(inputUser);

                    switch (opcaoConta) {
                        case 1 -> {
                            System.out.print("\nDigite o valor do depósito: ");
                            double valor = inputUser.nextDouble();
                            gerenciadorContas.getContasCorrente().get(gerenciadorContas.getContasCorrente().size() - 1)
                                    .deposito(valor);
                        }
                        case 2 -> {
                            gerenciadorContas.getContasCorrente().get(gerenciadorContas.getContasCorrente().size() - 1)
                                    .consultarSaldo();
                        }
                        case 3 ->
                            System.exit(0);
                        default ->
                            System.out.println("Opção incorreta!");
                    }
                }
                case 2 -> {
                    if (gerenciadorContas.getContasPoupanca().isEmpty()) {
                        System.out.println("\nNenhuma conta poupança cadastrada!");
                        break;
                    }
                    gerenciadorContas.menuConta();
                    int opcaoConta = gerenciadorContas.validarEntradaInteira(inputUser);

                    switch (opcaoConta) {
                        case 1 -> {
                            System.out.print("\nDigite o valor do depósito: ");
                            double valor = inputUser.nextDouble();
                            gerenciadorContas.getContasPoupanca().get(gerenciadorContas.getContasPoupanca().size() - 1)
                                    .deposito(valor);
                        }
                        case 2 -> {
                            gerenciadorContas.getContasPoupanca().get(gerenciadorContas.getContasPoupanca().size() - 1)
                                    .consultarSaldo();
                        }
                        case 3 ->
                            System.exit(0);
                        default ->
                            System.out.println("Opção inválida!");
                    }
                }
                case 3 -> {
                    gerenciadorContas.cadastroTitular();
                }
                case 4 -> {
                    gerenciadorContas.listarcontas();
                }
                case 5 -> {
                    System.out.println("Obrigado por usar nosso banco. Até mais!");
                    System.exit(0);
                }
                default ->
                    System.out.println("Opção inválida!");
            }
        }

    }

}
