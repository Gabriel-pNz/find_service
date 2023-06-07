package service;

public class PrintService {
    public void boasVindas() {
        System.out.println("______     _______  ");
        System.out.println("|  ____|  / ______\\ ");
        System.out.println("| |__    | |_____  ");
        System.out.println("|  __|   \\_______ \\");
        System.out.println("| |        ______| |");
        System.out.println("|_|      |______/_/ ");
        printLoopWithSleep("=", 10, 30);
        printMessageWithSleep("\nBem vindo ao Find-Service\n", 200);
        printLoopWithSleep("=", 10, 30);
    }
    public void printOptions() {
        printMessageWithSleep("\n.", 320);
        printMessageWithSleep("\nEscolha uma opção e tecle Enter:  \n", 400);
        printMessageWithSleep("1 - Listar Produtos\n", 250);
        printMessageWithSleep("2 - Adicionar um Produto\n", 250);
        printMessageWithSleep("3 - Remover um Produto\n", 250);
        printMessageWithSleep("4 - Mostrar um Produto\n", 250);
        printMessageWithSleep("5 - Atualizar um Produto\n", 250);
        printMessageWithSleep("0 - Sair\n", 250);
    }

    public void saindo() {
        printMessageWithSleep("Saindo", 100);
        printLoopWithSleep(".", 420, 3);
        printMessageWithSleep("\nAté Breve!\n", 550);
    }

    private void printLoopWithSleep(String msg, int timer, int quantity) {
        try {
            for(int i = 0; i < quantity; i++){
                Thread.sleep(timer);
                System.out.print(msg);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printMessageWithSleep(String msg, int timer) {
        try {
             Thread.sleep(timer);
             System.out.print(msg);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
