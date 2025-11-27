package relatorio;

import dominio.Pedido;
import dominio.StatusPedido;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioVendas extends GeradorRelatorio{
    @Override
    protected String getTituloRelatorio() {
        return "RELATORIO DE VENDAS";
    }

    @Override
    protected String gerarConteudo(List<Pedido> pedidos) {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("PEDIDOS:\n\n");

        for (Pedido pedido : pedidos) {
            conteudo.append(String.format(
                    "ID: %-10s | Cliente: %-20s | Valor: R$ %8.2f | Status: %s\n",
                    pedido.getId().substring(0, 8),
                    pedido.getCliente().getNome(),
                    pedido.calcularValorTotal(),
                    pedido.getStatus()
            ));
        }

        return conteudo.toString();
    }

    @Override
    protected String gerarEstatisticas(List<Pedido> pedidos) {
        int totalPedidos = pedidos.size();

        BigDecimal valorTotal = pedidos.stream()
                .map(Pedido::calcularValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorMedio = totalPedidos > 0
                ? valorTotal.divide(BigDecimal.valueOf(totalPedidos), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO;

        long pedidosPagos = pedidos.stream()
                .filter(p -> p.getStatus() == StatusPedido.PAGAMENTO_APROVADO)
                .count();

        return String.format("""
            
            ESTATÍSTICAS:
            - Total de Pedidos: %d
            - Pedidos Pagos: %d
            - Valor Total: R$ %.2f
            - Ticket Médio: R$ %.2f
            """,
                totalPedidos, pedidosPagos, valorTotal, valorMedio);
    }
}
