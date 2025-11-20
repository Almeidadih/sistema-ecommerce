package dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/*
* Classe principal que representa um Pedido no e-commerce.
* Agrega Cliente , itens e dados para pagamento.
*/
public class Pedido {

    private String  id ;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private LocalDateTime dataHora;
    private BigDecimal desconto;
    private BigDecimal valorFrete;
    private StatusPedido status;
    private DadosPagamento dadosPagamento;
    private TipoFrete tipoFrete;

    public Pedido(String id, Cliente cliente, List<ItemPedido> itens, LocalDateTime dataHora, BigDecimal desconto, BigDecimal valorFrete,
                  StatusPedido status, DadosPagamento dadosPagamento, TipoFrete tipoFrete) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.itens = itens;
        this.dataHora = LocalDateTime.now();
        this.desconto = BigDecimal.ZERO;
        this.valorFrete = BigDecimal.ZERO;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.dadosPagamento = dadosPagamento;
        this.tipoFrete = tipoFrete;
    }

    public BigDecimal calcularSubtotal() {
        return itens.stream()
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public BigDecimal calcularValorTotal() {
        return calcularSubtotal()
                .subtract(desconto)
                .add(valorFrete);
    }

    public boolean isAprovado() {
        return this.status == StatusPedido.PAGAMENTO_APROVADO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }


    public TipoFrete getTipoFrete() {
        return tipoFrete;
    }


    @Override
    public String toString() {
        return String.format("Pedido #%s - Cliente: %s - Total: R$ %.2f" ,
                id.substring(0,8),cliente.getNome(),calcularValorTotal());
    }
}
