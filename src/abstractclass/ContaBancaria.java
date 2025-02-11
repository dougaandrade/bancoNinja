package abstractclass;

import interfaces.ContaInterface;

public abstract class ContaBancaria implements ContaInterface {

    protected String titular;
    protected double saldo;
    protected double valor;
    protected double saldocorrente;
    protected double saldopoupanca;

    protected ContaBancaria(double saldo, String titular, double valor) {
        this.titular = titular;
        this.saldo = saldo;
        this.valor = valor;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void taxa(double calculoValor) {
        double valorTx = 0.96;
        this.saldo = calculoValor * valorTx;
        System.out.println("Taxa aplicada");
    }

}
