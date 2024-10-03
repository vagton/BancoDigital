package br.com.BancoDigital;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);  // Chama o construtor da classe pai (Conta)
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();  // Chama o método da classe pai
    }
}

