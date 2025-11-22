package frete;

import dominio.Pedido;

import java.math.BigDecimal;

import static java.sql.DriverManager.println;

public class FreteTransportadora implements CalculadoraFrete{
    @Override
    public BigDecimal calcularFrete(Pedido pedido, String cep) {
        // Calculo baseado noi subtotal
        BigDecimal percentual = new BigDecimal("0.10");
        BigDecimal frete = pedido.calcularSubtotal().multiply(percentual);

        //Minimo de R$ 20
        if (frete.compareTo(new BigDecimal("20.00")) < 0) {
            frete = new BigDecimal("20.00");
        }

        {
            println("🚚 " + getNomeTransportadora() + ": R$ " + frete +
                    " (Prazo: " + getPrazoEntregaDias() + " dias)");
        }
        return frete;
    }

    @Override
    public String getNomeTransportadora() {
        return "Transportadora Parceira";
    }

    @Override
    public int getPrazoEntregaDias() {
        return 7;
    }
}
