package pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static java.sql.DriverManager.println;

public class PagamentoBoleto extends Pagamento {

    private final String codigoBarras;
    private final String linhaDigitavel;
    private final LocalDate dataVencimento;

    public PagamentoBoleto(BigDecimal valor) {
        super(valor);
        this.id = "BOL-" + UUID.randomUUID().toString().substring(0, 8);
        this.dataVencimento = LocalDate.now().plusDays(3);
        this.codigoBarras = gerarCodigoBarras();
        this.linhaDigitavel = gerarLinhaDigitavel();
    }

    @Override
    public void processar() {
        {
            println("\n🧾 Gerando Boleto Bancário...");
            println("   Código de Barras: " + codigoBarras);
            println("   Linha Digitável: " + linhaDigitavel);
            println("   Vencimento: " + dataVencimento);
            println("   ✓ Boleto gerado com sucesso!");
            println("   ⏳ Aguardando pagamento até " + dataVencimento);
        }
        this.status = StatusPagamento.PENDENTE;
    }

    @Override
    public String gerarComprovante() {
        return String.format("""
            ========================================
                    BOLETO BANCÁRIO
            ========================================
            ID: %s
            Valor: R$ %.2f
            Vencimento: %s
            
            Código de Barras:
            %s
            
            Linha Digitável:
            %s
            
            Status: %s
            ========================================
            """,
                id, valor, dataVencimento, codigoBarras, linhaDigitavel, status);
    }

    private String gerarCodigoBarras() {
        return "34191.09008 61199.001011 01234.567890 1 " +
                String.format("%014d", valor.multiply(BigDecimal.valueOf(100)).longValue());
    }

    private String gerarLinhaDigitavel() {
        return "34191.09008 61199.001011 01234.567890 1 " +
                System.currentTimeMillis() % 10000;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
}