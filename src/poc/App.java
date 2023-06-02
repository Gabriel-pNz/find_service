package poc;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Button button = new Button();

        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();
        Button b5 = new Button();

        button.addObserver(b1);
        button.addObserver(b2);
        button.addObserver(b3);
        button.addObserver(b4);
        button.addObserver(b5);

        button.click();
        Thread.sleep(1000);
        button.onRelease();
    }
}
