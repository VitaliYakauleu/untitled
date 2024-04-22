package runners;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println("Incremented by thread: " + Thread.currentThread().getName() + ", count: " + count);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();
    }
}