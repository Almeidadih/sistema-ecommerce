package dominio;

public class Cliente {

    private final String id;
    private final String nome;
    private final String email;
    private final String cep;
    private final TipoCliente tipo;
    private final TipoNotificacao tipoNotificacao;

    public Cliente(String id, String nome, String email, String cep, TipoCliente tipo) {
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome +'\''+
                ", tipo=" + tipo +
                '}';
    }
}
