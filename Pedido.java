import java.util.ArrayList;
import java.util.List;

class Pedido {
    private String nomeCliente;
    private double taxaServico;
    private List<ItemPedido> itens;

    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.taxaServico = taxaServico;
        this.itens = new ArrayList<>();
    }

    // Método para adicionar um item ao pedido com uma quantidade especificada
    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    // Método para calcular o total do pedido
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total + taxaServico;
    }

    // Método para obter a lista de itens do pedido
    public List<ItemPedido> getItens() {
        return itens;
    }

    public void limparPedido() {
        itens.clear();
        taxaServico = 0.0;
    }

    public double getTaxaServico() {
        return taxaServico;
    }
    
    public void adicionarTaxaServico(double taxa) {
        taxaServico += taxa;
    }

    public String getnomeCliente() {
        return nomeCliente;
    }
        
}