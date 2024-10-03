package br.com.BancoDigital;

public class Main {
    public static void main(String[] args) {
        // Cria o Banco
        Banco banco = new Banco("Banco Digital");
        
        // Cria os Clientes
        Cliente cliente1 = new Cliente("Ana Carla");
        Conta contaCorrente = new ContaCorrente(cliente1);
        banco.adicionarConta(contaCorrente);

        Cliente cliente2 = new Cliente("Marcelo Nunes");
        Conta contaPoupanca = new ContaPoupança(cliente2);
        banco.adicionarConta(contaPoupanca);

        // Testa Operações
        contaCorrente.depositar(500);
        contaCorrente.sacar(200);
        contaCorrente.transferir(100, contaPoupanca);
        contaCorrente.sacar(300);  // testa saque indevido
        contaCorrente.transferir(300, contaPoupanca); // testa transferência indevida
        
        // Testa o Imprimir extratos
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
        
        // Testar o Listando todos os clientes do banco
        banco.listarTodosOsClientes();
        System.out.println();

        // Testar o Listando o histórico de transações
        banco.listarHistoricoDeTransacoes();
    }
}
