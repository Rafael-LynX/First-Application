/*  
Projeto: Aplicação de banco
Autor: Rafael Vieira
Data: 11/04/2025
Descrição: Aplicação de banco com funcionalidades de conta, cliente e transações.
*/
package src.app;

import java.util.logging.Logger;
import src.model.Cliente;
import java.util.Scanner;
import src.model.Conta;
import src.service.BancoService;

import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger("AppLog");

        // Configurando o Logger para exibir apenas mensagens
        logger.setUseParentHandlers(false); // Remove o formato padrão
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(java.util.logging.LogRecord myRecord) {
                return myRecord.getMessage() + "\n"; // Apenas a mensagem
            }
        });
        logger.addHandler(handler);

        // Iniciando a aplicação
        logger.info("Aplicação de Banco Iniciada!");
        
        // Coleta de dados do cliente segura
        logger.info("Digite seu nome: ");
        String nome = scanner.nextLine().trim();

        String senhaStr;
        while (true) {
            logger.info("Digite uma senha (mínimo 4 caracteres): ");
            senhaStr = scanner.nextLine().trim();
            if (senhaStr.length() >= 4) break;
            logger.warning("Senha deve ter pelo menos 4 caracteres.");  
        }

        // Criando clientes com segurança
        Cliente cliente = new Cliente(nome, senhaStr.toCharArray());

        // Criando conta
        Conta conta = new Conta("12345"); // Inicializando com saldo 0.0

        // Inicializando bancoservice
        BancoService bancoService = new BancoService(cliente, conta);

        logger.info("Cliente criado com sucesso! Nome: ");
        logger.info("Nome: " + cliente.getNome());
        
        
        // Menu
        while (true) {
            logger.info("-- Menu --");
            logger.info("1. Consultar Saldo");
            logger.info("2. Depositar");
            logger.info("3. Transferir");
            logger.info("4. Sair");
            logger.info("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    bancoService.exibirSaldo();
                    break;
                case 2:
                    logger.info("Digite o valor a depositar: ");
                    double deposito = scanner.nextDouble();
                    bancoService.depositar(deposito);
                    break;
                case 3:
                    logger.info("Digite o valor para Transferência: ");
                    double transferencia = scanner.nextDouble();
                    bancoService.transferir(conta, transferencia);
                    break;
                case 4:
                    logger.info("Saindo...");
                    cliente.limparSenha();
                    scanner.close();
                    return;
                default:
                    logger.warning("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
    

}
