package tiposcontas;

import abstractclass.ContaBancaria;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(double saldo, String titular, double valor) {
        super(saldo, titular, valor, "Conta Corrente");
    }

    @Override
    public void deposito(double valor) {
        if (valor > 0) {
            System.out.println("Valor depositado");
            taxa(valor);
            saldocorrente = this.saldo;
        } else {
            System.out.println("Não foi de positado nenhum valor");
        }
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo é: " + this.saldo);

    }
}
