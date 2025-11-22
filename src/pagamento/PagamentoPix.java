package pagamento;

import java.math.BigDecimal;
import java.util.UUID;

import static java.sql.DriverManager.println;

/**
 * Implementação CONCRETA de Pagamento via PIX.
 *
 * POLIMORFISMO: Mesmo tipo base (Pagamento), comportamento específico
 */
public class PagamentoPix extends Pagamento {
    private String chavePix;
    private String codigoQR;

    public PagamentoPix(BigDecimal valor, String chavePix) {
        super(valor);
        this.id = "PIX-" + UUID.randomUUID().toString().substring(0, 8);
        this.chavePix = chavePix;
        this.codigoQR = gerarCodigoQR();
    }

    @Override
    public void processar() {
        {
            println("\n📱 Processando Pagamento via PIX...");
            println("   Chave PIX: " + chavePix);
            println("   Código QR: " + codigoQR);
            println("   Aguardando confirmação...");
        }
        // Simulação de processamento instantâneo
        try {
            Thread.sleep(800);
            println("   ✓ Pagamento confirmado instantaneamente!");
            this.status = StatusPagamento.ARPOVADO;
        } catch (InterruptedException e) {
            this.status = StatusPagamento.CANCELADO;
        }
    }

    @Override
    public String gerarComprovante() {
        return String.format("""
            ========================================
                 COMPROVANTE DE PAGAMENTO
            ========================================
            Método: PIX
            ID Transação: %s
            Chave PIX: %s
            Valor: R$ %.2f
            Status: %s
            ========================================
            """,
                id, chavePix, valor, status);
    }

    private String gerarCodigoQR() {
        return "00020126" + UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }

    public String getCodigoQR() {
        return codigoQR;
    }
}
