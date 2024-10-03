package br.com.BancoDigital;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Transaçao {
    private final LocalDateTime dataHora;
    private final String tipo; // "DEPOSITO", "SAQUE", "TRANSFERENCIA"
    private final double valor;
    private final Conta contaOrigem; // Para transferências, a conta de origem
    private final Conta contaDestino; // Para transferências, a conta de destino (pode ser null para depósitos e saques)

    @Override
    public String toString() {
        return String.format("%s: R$ %.2f na conta %d", tipo, valor, contaOrigem.getNumero());
    }
}
