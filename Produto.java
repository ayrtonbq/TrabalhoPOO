import java.util.Date;

class Produto {
    private String nome;
    private double preco;
    private String descricao;
    private Date dataValidade;

    public Produto(String nome, double preco, String descricao, Date dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }
}