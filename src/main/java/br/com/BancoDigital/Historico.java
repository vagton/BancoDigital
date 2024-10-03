package br.com.BancoDigital;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Historico {
    private final List<Transaçao> transacoes;

    public Historico() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransaçao(Transaçao transacao) {
        transacoes.add(transacao);
    }

    public void imprimirHistorico() {
        for (Transaçao transacao : transacoes) {
            System.out.println(transacao);
        }
    }
}
