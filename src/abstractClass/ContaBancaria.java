package abstractClass;

import interfaces.ContaInterface;

public abstract class ContaBancaria implements ContaInterface {

    protected String titular;
    protected double saldo;
    protected double valor;

    protected ContaBancaria(double saldo, String titular, double valor) {
        this.titular = titular;
        this.saldo = saldo;
        this.valor = valor;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void taxa(double calculoValor) {
        double valorTx = 0.96;
        this.saldo = calculoValor * valorTx;
        System.out.println("Taxa aplicada");
    }

}
