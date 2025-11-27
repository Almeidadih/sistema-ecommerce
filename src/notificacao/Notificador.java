package notificacao;

import dominio.Pedido;

/*
* INTERFACE para diferentes canais de notificacao
*
* POLIMORFISMO; Mesmo contrato, implementacao diferentes
* */
public interface Notificador {

    void  enviarConfirmacaoPedido(Pedido pedido) ;

    void enviarConfirmacaoPagamento(Pedido pedido);

    void  enviarNotificacaoEnvio(Pedido pedido, String codigoRastreio);

    String getTipoNotificacao();
}
