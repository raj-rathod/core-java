package thread;

public class MessageBox {
       private String message;
    private boolean empty = true;

    public  synchronized void put(String msg) {
        while (!empty) {   // box full → wait
            try { wait(); } catch (InterruptedException e) {}
        }
        message = msg;
        empty = false;
        System.out.println("Produced: " + msg);
        notify(); // notify consumer
    }

    public synchronized  String get() {
        while (empty) {   // box empty → wait
            try { wait(); } catch (InterruptedException e) {}
        }
        empty = true;
        System.out.println("Consumed: " + message);
        notify(); // notify producer
        return message;
    }
}
