import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        Pedido pedido = new Pedido(nomeCliente, 2.0);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Selecione um item:");
            System.out.println("1. Pizza - R$25.0");
            System.out.println("2. Lanche - R$10.0");
            System.out.println("3. Salgadinho");
            System.out.println("0. Finalizar pedido");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    adicionarPizza(pedido, scanner);
                    break;
                case 2:
                    adicionarLanche(pedido, scanner);
                    break;
                case 3:
                    adicionarSalgadinho(pedido, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        pedido.adicionarTaxaServico(5.0); // Adicionando uma taxa de serviço fixa de 5 reais

        double totalPedido = pedido.calcularTotal();
        System.out.println("\n----- Pedido -----");
        System.out.print("\n");
        System.out.println("Cliente: " + pedido.getnomeCliente());
        System.out.println("Produtos comprados:");

        // Mostrar produtos comprados e seus valores
        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.getProduto().getDescricao() + " - R$" + item.getProduto().getPreco() + " x " + item.getQuantidade());
        }

        // Mostrar a taxa de serviço
        System.out.println("Taxa de serviço: R$" + pedido.getTaxaServico());

        // Mostrar o total do pedido
        System.out.println("Total do pedido: R$" + totalPedido);
        System.out.println("\n------------------");

        // Perguntar se deseja continuar pedindo
        System.out.println("Deseja continuar pedindo? (s/n)");
        String resposta = scanner.next();
        if (resposta.equalsIgnoreCase("s")) {
            // Limpar o pedido atual e continuar
            pedido.limparPedido();
            main(args); // Chamada recursiva para reiniciar o processo de pedidos
        } else {
            System.out.println("Obrigado por utilizar nosso sistema de pedidos!");
        }
    }

    private static void adicionarPizza(Pedido pedido, Scanner scanner) {
        System.out.println("Selecione o recheio da pizza:");
        System.out.println("1. Calabresa");
        System.out.println("2. Frango com Catupiry");
        int escolhaRecheio = scanner.nextInt();

        System.out.println("Deseja borda recheada? (s/n)");
        boolean bordaRecheada = scanner.next().equalsIgnoreCase("s");

        System.out.println("Selecione o molho da pizza:");
        System.out.println("1. Tomate");
        System.out.println("2. Barbecue");
        int escolhaMolho = scanner.nextInt();

        double preco = 25.0; 
        String recheio = "";
        String molho = "";

        switch (escolhaRecheio) {
            case 1:
                recheio = "Calabresa";
                break;
            case 2:
                recheio = "Frango com Catupiry";
                break;
            default:
                break;
        }

        if (bordaRecheada) {
            preco += 5.0; 
        }

        switch (escolhaMolho) {
            case 1:
                molho = "Tomate";
                break;
            case 2:
                molho = "Barbecue";
                break;
            default:
                break;
        }

        String descricao = "Pizza " + recheio + " com borda " + (bordaRecheada ? "recheada" : "normal") + " e molho " + molho;
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        Produto pizza = new Produto("Pizza", preco, descricao, new Date());
        pedido.adicionarItem(pizza, quantidade);
    }

    private static void adicionarLanche(Pedido pedido, Scanner scanner) {
        System.out.println("Escolha o tipo de lanche:");
        System.out.println("1. X-Salada");
        System.out.println("2. X-Bacon");
        int escolhaLanche = scanner.nextInt();

        double preco = 10.0; 
        String tipoLanche = "";

        switch (escolhaLanche) {
            case 1:
                tipoLanche = "X-Salada";
                break;
            case 2:
                tipoLanche = "X-Bacon";
                break;
            default:
                break;
        }

        String descricao = "Lanche " + tipoLanche;
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        Produto lanche = new Produto("Lanche", preco, descricao, new Date());
        pedido.adicionarItem(lanche, quantidade);
    }

    private static void adicionarSalgadinho(Pedido pedido, Scanner scanner) {
        System.out.println("Escolha o tipo de salgadinho:");
        System.out.println("1. Frito");
        System.out.println("2. Assado");
        int escolhaTipo = scanner.nextInt();
    
        String tipoSalgadinho = "";
        double preco = 0.0;
    
        switch (escolhaTipo) {
            case 1:
                System.out.println("Selecione o salgadinho frito:");
                System.out.println("1. Coxinha - R$7.0");
                System.out.println("2. Quibe - R$7.0");
                System.out.println("3. Cigarrete - R$7.0");
                int escolhaFrito = scanner.nextInt();
                switch (escolhaFrito) {
                    case 1:
                        tipoSalgadinho = "Coxinha frita";
                        preco = 7.0;
                        break;
                    case 2:
                        tipoSalgadinho = "Quibe frito";
                        preco = 7.0;
                        break;
                    case 3:
                        tipoSalgadinho = "Cigarrete frito";
                        preco = 7.0;
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                System.out.println("Selecione o salgadinho assado:");
                System.out.println("1. Hamburguer assado - R$8.0");
                System.out.println("2. Rissole de Queijo assado - R$7.0");
                int escolhaAssado = scanner.nextInt();
                switch (escolhaAssado) {
                    case 1:
                        tipoSalgadinho = "Hamburguer assado";
                        preco = 5.0;
                        break;
                    case 2:
                        tipoSalgadinho = "Rissole de Queijo assado";
                        preco = 3.5;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        String descricao = "Salgadinho " + tipoSalgadinho;
        Produto salgadinho = new Produto("Salgadinho", preco, descricao, new Date());
        pedido.adicionarItem(salgadinho, quantidade);
    }
}
