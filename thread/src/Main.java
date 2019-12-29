import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {

            new MyThread().start();
            MyRunnable myRunnable = new MyRunnable();
            Thread thread2 = new Thread(myRunnable);
            thread2.start();

        }
Thread.sleep(2000);
        System.out.println(atomicInteger.get());
    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            atomicInteger.getAndIncrement();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            atomicInteger.getAndIncrement();

        }
    }
}
