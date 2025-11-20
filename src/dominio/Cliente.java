package dominio;

public class Cliente {

    private String id;
    private String nome;
    private String email;
    private String cep;
    private TipoCliente tipo;
    private TipoNotificacao tipoNotificacao;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoCliente getTipo() {
        return tipo;
    }
}
