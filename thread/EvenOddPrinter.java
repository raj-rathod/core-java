package thread;

public class EvenOddPrinter {
    private int number = 1;
    private int limit;

    public EvenOddPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (number <= limit) {
            if (number % 2 == 0) {           // not odd → wait
                try { wait(); } catch (Exception e) {}
            }

            System.out.println("Odd  : " + number);
            number++;
            notify();                       // wake even thread
        }
    }

    public synchronized void printEven() {
        while (number <= limit) {
            if (number % 2 == 1) {           // not even → wait
                try { wait(); } catch (Exception e) {}
            }

            System.out.println("Even : " + number);
            number++;
            notify();                       // wake odd thread
        }
    }
}
