package frete;

import dominio.Pedido;

import java.math.BigDecimal;

/*
    * STRATEFY PATTERN - Interface para cálculo de frete
    *
    * POLIMORFIRSMO: Diferentes transportadoras calculam de formas diferentes
    * */
public interface CalculadoraFrete {

    BigDecimal calcularFrete(Pedido pedido, String cep);

    String getNomeTransportadora();

    int getPrazoEntregaDias();
}
