//import java.util.function.Consumer;

public class SynchronizedTests1 {

    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();
//        Thread thread1 = new Thread(() -> {
//            for(int i=0;i<10000;i++){
//                counter.inc();
//            }
//            System.out.println("final1:" + counter.count);
//        });
//        Thread thread2 = new Thread(() -> {
//            for(int i=0;i<10000;i++){
//                counter.inc();
//            }
//            System.out.println("final2:" + counter.count);
//        });
//        thread1.start();
//        thread2.start();
    }

    public static class SyncCounter{
        private long count = 0;
        public void inc(){
            this.count++;
            System.out.println(this.count);
        }
    }
}
