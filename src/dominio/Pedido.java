package dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.dataHora = dataHora;
        this.desconto = desconto;
        this.valorFrete = valorFrete;
        this.status = status;
        this.dadosPagamento = dadosPagamento;
        this.tipoFrete = tipoFrete;
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

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }

    public TipoFrete getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(TipoFrete tipoFrete) {
        this.tipoFrete = tipoFrete;
    }
}
