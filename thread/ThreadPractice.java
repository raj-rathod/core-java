package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class NumberPrinter{
    int n = 200;
    int number = 1;
    static int count = 1;
    public void printInOrderNumber(){
        for(int i=1; i<=n;i++){
            System.out.println(i);
        }
    }

    public void printReverseOrderNumber(){
        for(int i=n; i>0;i--){
            System.out.println(i);
        }
    }

    public synchronized void counter(){
        while (count< 200) {
            System.out.println(count++);
        }
    }

    public synchronized void printEven(){
        while(number <= n){
            if(number % 2 != 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    
                }
            }else{
               System.out.println(number);
               number++;
               notify();
            }
        }
    }

     public synchronized void printOdd(){
        while(number <= n){
            if(number % 2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    
                }
            }else{
               System.out.println(number);
               number++;
               notify();
            }
        }
    }

    public synchronized void print(int remainder) {
        while (number <= n) {
            if (number % 3 != remainder) {
                try { wait(); } catch (Exception e) {}
            } else {
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
                notifyAll();
            }
        }
    }
}

public class ThreadPractice {
    public void printNumberInOrderAndReverse(){
        NumberPrinter printer = new NumberPrinter();
        Thread t1 = new Thread(printer::printInOrderNumber);
        Thread t2 = new Thread(printer:: printReverseOrderNumber);
        try {

            t1.start();
                t1.join();
            t2.start();
                t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void threadCounter(){
        NumberPrinter printer = new NumberPrinter();
        Thread t1 = new Thread(printer::counter);
        Thread t2 = new Thread(printer::counter);

        t1.start();
        t2.start();
        
    }

    public void  printEvenOdd(){
        NumberPrinter printer = new NumberPrinter();
        Thread t1 = new Thread(printer::printEven);
        Thread t2 = new Thread(printer::printOdd);

        t1.start();
        t2.start();
    }

    public void producerConsumer(){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = ()->{
            int i = 1;
            try {
                while(true){
                    queue.put(i);
                    System.out.println("Produced: " + i++);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        };

         Runnable consumer = () -> {
            try {
                while (true) {
                    int val = queue.take();
                    System.out.println("Consumed: " + val);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {}
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    public void printSequenceUsingThreeThread(){
        NumberPrinter printer = new NumberPrinter();
        new Thread(()-> printer.print(1)).start();
        new Thread(()-> printer.print(2)).start();
        new Thread(()-> printer.print(0)).start();

    }


}
