
import abstractclass.ContaBancaria;
import interfaces.TitularInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tiposcontas.ContaCorrente;
import tiposcontas.ContaPoupanca;

public class GerenciadorContas implements TitularInterface {

    protected final List<ContaBancaria> contas;
    protected final Scanner scanner;

    public GerenciadorContas(Scanner scanner) {
        this.contas = new ArrayList<>();
        this.scanner = scanner;
    }

    @Override
    public void cadastroTitular() {
        System.out.println("\n_________Nova Conta_________\n");
        System.out.print("\nNome: ");
        String titular = scanner.nextLine();

        System.out.println("\n1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("\nEscolha uma opção: ");

        int escolha = validarEntradaInteira(scanner);
        ContaBancaria novaConta = criarConta(escolha, titular);

        switch (escolha) {
            case 1 ->
                contas.add(novaConta);
            case 2 ->
                contas.add(novaConta);
            default ->
                System.out.println("\nOpção inválida! Cadastro cancelado.");
        }

        System.out.println("\nConta criada com sucesso para " + titular);
    }

    private ContaBancaria criarConta(int tipo, String titular) {
        double saldoInicial = 300;
        return switch (tipo) {
            case 1 ->
                new ContaCorrente(saldoInicial, titular, 0);
            case 2 ->
                new ContaPoupanca(saldoInicial, titular, 0);
            default ->
                null;
        };
    }

    public final void menu() {
        System.out.println("\n________________Banco Nacional de Konohagakure________________\n");
        System.out.println("\nBem-vindo ao nosso banco!\n");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Cadastro de Conta");
        System.out.println("4 - Listar Contas");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public final void menuConta() {
        System.out.println("\n__________Bem-vindo__________\n");
        System.out.println("\n1 - Depósito");
        System.out.println("2 - Saldo");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void contasAtivas() {
        System.out.println("\nContas ativas:\n");
        contas.forEach(conta -> System.out.println(conta.getTitular() + " - " + conta.getTipoConta()));
    }

    public void listarcontas() {
        contasAtivas();
    }

    public List<ContaBancaria> getContasCorrente() {
        return contas;
    }

    public List<ContaBancaria> getContasPoupanca() {
        return contas;
    }

    public int validarEntradaInteira(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("\nPor favor, insira um número válido: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

}
