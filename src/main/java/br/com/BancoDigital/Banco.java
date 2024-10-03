package br.com.BancoDigital;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarTodosOsClientes() {
        System.out.println("Clientes do banco " + nome + ":");
        for (Conta conta : contas) {
            System.out.println(conta.getCliente().getNome());
        }
    }

    public void listarHistoricoDeTransacoes() {
        for (Conta conta : contas) {
            System.out.println("Histórico da conta " + conta.getNumero() + ":");
            conta.getHistorico().imprimirHistorico();
        }
    }
}
