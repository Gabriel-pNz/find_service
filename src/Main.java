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

            if (option < 0 || option > 4) {
                continue;
            }
        } while (option != 0);

        printUtil.saindo();
    }


    public static int scanInt(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                return Integer.parseInt(scanner.nextLine());
            }
            scanner.nextLine();
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

}