package src.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import src.model.Cliente;
import src.model.Conta;

public class BancoService {
    private static final Logger logger = Logger.getLogger(BancoService.class.getName());
    private Cliente cliente;
    private Conta conta;   
    

    public BancoService(Cliente cliente, Conta conta) {
        this.cliente = cliente;
        this.conta = conta;
    }

    public void exibirSaldo() {  
        logger.info("Cliente: " + cliente.getNome());
        logger.info("Tipo de Conta: Corrente");
        logger.info("Saldo atual: " + conta.getSaldo());
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            logger.log(Level.WARNING, () -> String.format("Valor de depósito inválido: %.2f", valor));
            return;
        }
        conta.depositar(valor);
        logger.log(Level.INFO, () -> String.format("Depósito de %.2f realizado com sucesso!", valor));
    }

    public void transferir(Conta destino, double valor) {
        if (valor <= 0) {
            logger.log(Level.WARNING, () -> String.format("Valor de transferência inválido: %.2f", valor));
            return;
        }
        boolean sucesso = conta.transferirPara(destino, valor);
        if (sucesso) {
            logger.log(Level.INFO, () -> String.format("Transferência de %.2f realizada com sucesso!", valor));
        } else {
            logger.log(Level.WARNING, () -> String.format("Transferência de %.2f falhou. Verifique o saldo.", valor));
        }
    }

    public Conta getConta() {
            return conta;
        
    }
}
