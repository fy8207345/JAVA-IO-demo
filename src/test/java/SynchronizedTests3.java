//import java.util.function.Consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedTests3 {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable get = new Runnable() {
            @Override
            public void run() {
                try {
                    counter.getCount();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable set = new Runnable() {
            @Override
            public void run() {
                try {
                    counter.setCount(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(set);
        executorService.execute(get);
        executorService.execute(get);
        executorService.execute(set);
        executorService.submit()

        executorService.shutdown();
    }

    public static class Counter{
        private int count;
        private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock(true);
        private ReentrantReadWriteLock.WriteLock writeLock = reentrantLock.writeLock();
        private ReentrantReadWriteLock.ReadLock readLock = reentrantLock.readLock();

        public  void setCount(int count) throws InterruptedException {
            try {
                writeLock.lock();
                System.out.println(Thread.currentThread().getName() + "set count: "+ count);
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "release set lock ");
                this.count = count;
            }finally {
                writeLock.unlock();
            }
        }

        public  int getCount() throws InterruptedException {
            try {
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + "get count: "+ count);
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "release get lock ");
                return count;
            }finally {
                readLock.unlock();
            }
        }
    }
}
