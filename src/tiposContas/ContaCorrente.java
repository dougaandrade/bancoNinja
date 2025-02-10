package tiposContas;

import abstractClass.ContaBancaria;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(double saldo, String titular, double valor) {
        super(saldo, titular, valor);
    }

    @Override
    public void deposito(double valor) {
        if (valor > 0) {
            this.saldo += saldo;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar o depósito!");
        }

    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo: " + this.saldo);
    }

}
