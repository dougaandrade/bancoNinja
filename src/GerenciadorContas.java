
import abstractClass.ContaBancaria;
import interfaces.TitularInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tiposContas.ContaCorrente;
import tiposContas.ContaPoupanca;

public class GerenciadorContas implements TitularInterface {

    protected final List<ContaBancaria> contas;
    protected final Scanner scanner;

    public GerenciadorContas(Scanner scanner) {
        this.contas = new ArrayList<>();
        this.scanner = scanner;
    }

    @Override
    public void cadastroTitular() {
        System.out.println("______Nova Conta______");
        System.out.print("Nome: ");
        String titular = scanner.nextLine();
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupança");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            contas.add(new ContaCorrente(300, titular, 0));
        } else if (escolha == 2) {
            contas.add(new ContaPoupanca(300, titular, 0));
        }

    }
}
