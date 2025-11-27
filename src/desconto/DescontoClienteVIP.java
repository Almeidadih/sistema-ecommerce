package desconto;

import dominio.Pedido;
import dominio.TipoCliente;

import java.math.BigDecimal;

import static java.sql.DriverManager.println;

/*
* Estrategia CONCRETA: Desconto para Clientes VIP
*
* Regra de Negocios: 15% de desconto para clientes VIP
* */
public class DescontoClienteVIP implements Desconto{

    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.15");

    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        if (pedido.getCliente().getTipo() == TipoCliente.VIP) {
            BigDecimal desconto = pedido.calcularSubtotal().multiply(PERCENTUAL_DESCONTO);
            println("🌟 Desconto VIP aplicado: 15% = R$ " + desconto);
            return desconto;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String getDescricao() {
        return "Desconto Cliente VIP(15%)";
    }
}
