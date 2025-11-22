package pagamento;

import dominio.Pedido;
import frete.FreteService;

import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

public class PedidoService {

    private static final List<Pedido> PEDIDOS = new ArrayList<>();

    public static void efetuarPedido(Pedido pedido) {

        {
            println("\n📦 Iniciando criação do pedido: " + pedido);
            println(" Total: R$ " + pedido.calcularSubtotal());
        }

        DescontoService.aplicarDesconto(pedido);
        FreteService.aplicarFrete(pedido);
        PEDIDOS.add(pedido);
        {
            println("\n📦 Pedido criado: " + pedido);
            println(" Subtotal: R$ " + pedido.calcularSubtotal());
        }
        PagamentoService.processarPagamento(pedido);
        NotificacaoService.enviarNotificacoes(pedido);
    }

    public static List<Pedido> findQPedidos() {
        return PEDIDOS;
    }
}
