package frete;

import dominio.Pedido;

import java.math.BigDecimal;

import static java.sql.DriverManager.println;

public class FreteSedex implements CalculadoraFrete{
    @Override
    public BigDecimal calcularFrete(Pedido pedido, String cep) {

        BigDecimal taxaBase = new BigDecimal("20.00");
        BigDecimal valorPorItem = new BigDecimal("1.00");

        int quantidadeItens = pedido.getItens().size();

        BigDecimal frete = taxaBase.add(valorPorItem.multiply(BigDecimal.valueOf(quantidadeItens)));

        {
            println("⚡ SEDEX: R$ " + frete +
                    " (Prazo: " + getPrazoEntregaDias() + " dias)");
        }

        return frete;
    }

    @Override
    public String getNomeTransportadora() {
        return "SEDEX";
    }

    @Override
    public int getPrazoEntregaDias() {
        return 3;
    }
}
