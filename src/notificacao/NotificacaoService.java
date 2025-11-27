package notificacao;

import dominio.Pedido;
import notificacao.factory.NotificadorFactory;
import notificacao.factory.TipoNotificacao;

import static java.sql.DriverManager.println;

public class NotificacaoService {

    public static void enviarNotificacoes(Pedido pedido) {
        TipoNotificacao tipoNotificacao = pedido.getCliente().getTipoNotificacao();

        Notificador notificador = NotificadorFactory.criar(tipoNotificacao);
        {
            println("\n📢 Enviando notificações via " + notificador.getTipoNotificacao());
        }

        notificador.enviarConfirmacaoPedido(pedido);

        if (pedido.isAprovado()) {
            notificador.enviarConfirmacaoPagamento(pedido);
            notificador.enviarNotificacaoEnvio(pedido, NotificacaoService.findCodRastreio());
        }
    }

    private static String findCodRastreio(){
        return "BR" + System.currentTimeMillis() % 100000000;
    }
}
