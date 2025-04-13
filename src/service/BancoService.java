package src.service;

import java.util.logging.Logger;
import src.model.Cliente;
import src.model.Conta;

public class BancoService {
    private Cliente cliente;
    private Conta conta;   

    public BancoService(Cliente cliente, Conta conta) {
        this.cliente = cliente;
        this.conta = conta;
    }

    public void exibirSaldo() {
        Logger logger = Logger.getLogger("BancoServiceLog");
        logger.info("Cliente: " + cliente.getNome());
        logger.info("Tipo de Conta: Corrente");
        logger.info("Saldo atual: " + conta.getSaldo());
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            Logger logger = Logger.getLogger("BancoServiceLog");
            logger.warning("Valor de depósito inválido: " + valor);
            return;
        }
        conta.depositar(valor);
        Logger logger = Logger.getLogger("BancoServiceLog");
        logger.info("Depósito de " + valor + " realizado com sucesso!");
    }

    public void transferir( double valor) {
        if (valor <= 0) {
            Logger logger = Logger.getLogger("BancoServiceLog");
            logger.warning("Valor de transferência inválido: " + valor);
            return;
        }
        boolean sucesso = conta.transferirPara(valor);
        if (sucesso) {
            Logger logger = Logger.getLogger("BancoServiceLog");
            logger.info("Transferência de " + valor + " realizada com sucesso!");
        } else {
            Logger logger = Logger.getLogger("BancoServiceLog");
            logger.warning("Transferência falhou. Verifique o saldo.");
        }
    }

    public Conta getConta() {
            return conta;
        
    }
}
