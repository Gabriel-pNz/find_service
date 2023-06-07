import model.Produto;
import service.ProdutoService;
import service.PrintService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintService printUtil = new PrintService();
        ProdutoService produtoService = new ProdutoService();
        Scanner scanner = new Scanner(System.in);

        int option;

        printUtil.boasVindas();

        do {
            printUtil.printOptions();
            option = scanInt(scanner);

            if (option == 1) {
                System.out.println(produtoService.listarProdutos());

            } else if (option == 2) {

                System.out.println("Informe o nome do produto");
                String nome = scanner.nextLine();

                System.out.println("Informe o preço do produto");
                double preco = scanDouble(scanner);

                System.out.println("Informe uma descrição para o produto");
                String descricao = scanner.nextLine();

                System.out.println("Informe um id para o produot");
                int id = scanInt(scanner);

                produtoService.adicionarProduto(new Produto(nome, preco, descricao, id));

            } else if (option == 3) {

                System.out.println("Informe o index do produto a ser removido");
                int index = scanInt(scanner);
                produtoService.deletarProduto(index);

            } else if (option == 4) {
                System.out.println("Informe o ID do produto que deseja consultar");
                int resposta = scanInt(scanner);
                System.out.println(produtoService.buscarUm(resposta));

            } else if (option == 5) {

                System.out.println("Informe o novo nome do produto");
                String nome = scanner.nextLine();

                System.out.println("Informe o  novo preço do produto");
                double preco = scanDouble(scanner);

                System.out.println("Informe a nova descrição do produto");
                String descricao = scanner.nextLine();

                System.out.println("Informe o novo id do produto");
                int id = scanInt(scanner);

                produtoService.alterarProduto(new Produto(nome, preco, descricao, id));
            } else {
                System.out.println("Valor inválido, tente novamente!");
            }

        } while (option !=0 );
        scanner.close();
        printUtil.saindo();
    }

    public static int scanInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return Integer.parseInt(scanner.nextLine());
        }
        scanner.nextLine();
        return -1;
    }

    public static double scanDouble(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return Double.parseDouble(scanner.nextLine());
        }
        scanner.nextLine();
        return -1;
    }

}