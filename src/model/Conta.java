package src.model;

public class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } 
    }

    public boolean transferirPara(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        } 
        return false;
    }

    public String getNumero() {
        return numero;
    }
}
