package desconto;

import dominio.Pedido;

import java.math.BigDecimal;

import static java.sql.DriverManager.println;

public class DescontoPromocional implements Desconto {

    private static final BigDecimal VALOR_MINIMO = new BigDecimal("500.00");
    private static final BigDecimal VALOR_DESCONTO = new BigDecimal("50.00");

    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        if (pedido.calcularSubtotal().compareTo(VALOR_MINIMO) >= 0) {
            {
                println("🎉 Desconto Promocional aplicado: R$ " + VALOR_DESCONTO);
            }
            return VALOR_DESCONTO;
        }
        return BigDecimal.ZERO;
    }


    @Override
    public String getDescricao() {
    return "Desconto Promocional (R$ 50 acima de R% 500)";
    }
}
