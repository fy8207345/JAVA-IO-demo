import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SynchronizedTests2 {

    public static void main(String[] args) throws InterruptedException {
        SyncCounter counter = new SyncCounter();
        Thread thread1 = new Thread(new CounterThread(counter));
        Thread thread2 = new Thread(new CounterThread(counter));
        thread1.start();
        thread2.start();

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        System.out.println(deadlockedThreads);
        System.out.println(threadMXBean.getThreadCount());
        System.out.println(Arrays.toString(threadMXBean.getAllThreadIds()));

        List<Object> objects = new ArrayList<>();
        objects.add("haha");
        WeakReference<List<Object>> reference = new WeakReference<>(objects);
        System.runFinalization();
        Thread.sleep(5000);
        List<Object> objectList = reference.get();
        System.out.println(objectList);
    }

    public static class CounterThread implements Runnable{

        private SyncCounter counter;

        public CounterThread(SyncCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for(int i=0;i<10000;i++){
                counter.inc();
            }
            System.out.println("final:" + counter.count);
        }
    }

    public static class SyncCounter{
        private long count = 0;
        public void inc(){
            this.count++;
//            System.out.println(this.count);
        }
    }
}
