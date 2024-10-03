package br.com.BancoDigital;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected Historico historico; // Novo atributo

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historico = new Historico(); // Inicializa o histórico
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            historico.adicionarTransaçao(new Transaçao(LocalDateTime.now(), "SAQUE", valor, this, null)); // Registra transação
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para saque!");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        historico.adicionarTransaçao(new Transaçao(LocalDateTime.now(), "DEPOSITO", valor, this, null)); // Registra transação
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
    }

    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historico.adicionarTransaçao(new Transaçao(LocalDateTime.now(), "TRANSFERENCIA", valor, this, contaDestino)); // Registra transação
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para transferência!");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Número: %d", numero));
        System.out.println(String.format("Saldo: R$ %.2f", saldo));
    }
}
