package pagamento.factory;

import dominio.DadosCartao;
import pagamento.Pagamento;
import pagamento.PagamentoBoleto;
import pagamento.PagamentoCartao;
import pagamento.PagamentoPix;
import pagamento.PagamentoiCartao;
import pedido.DadosPagamento;

import java.math.BigDecimal;

import static pagamento.factory.TipoPagamento.*;

public class PagamentoFactory {

    public static Pagamento criar(DadosPagamento dadosPagamento, BigDecimal valor) {

        switch (dadosPagamento.getTipoPagamento()) {
            case CARTAO_CREDITO -> {
                DadosCartao dadosCartao = dadosPagamento.getDadosCartao().orElseThrow();
                return new PagamentoCartao(
                        valor,
                        dadosCartao.getNumeroCartao(),
                        dadosCartao.getNomeTitular(),
                        dadosCartao.getCodigoSeguranca(),
                        dadosCartao.getQuantidadeParcelas());
            }
            case PIX -> {
                String chavePix = dadosPagamento.getChavePix().orElseThrow();
                return new PagamentoPix(valor,chavePix);
            }
            case BOLETO -> {
                return new PagamentoBoleto(valor);
            }
            default -> throw new IllegalArgumentException("Tipo de pagamento não suportado: " + dadosPagamento.getTipoPagamento());
        }

    }
}
