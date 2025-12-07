import thread.EvenOddPrinter;

public class Main {
    public static void main(String[] arg) {
     EvenOddPrinter printer = new EvenOddPrinter(20);

        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
      
    }
}
