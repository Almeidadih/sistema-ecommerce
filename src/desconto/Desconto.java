package desconto;

import dominio.Pedido;

import java.math.BigDecimal;

/*
* POLIMORFISMO através  de INTERFACE
* */
public interface Desconto {

    /*
     * Calcula o desconto aplicavel ao pedido.
     * Cada estrategia implementa sua regra de negocio.
     * */
    BigDecimal calcularDesconto(Pedido pedido);

    /*
    * Retorna descrição da estratégia para logs/relatorios */
    String getDescricao();
}
