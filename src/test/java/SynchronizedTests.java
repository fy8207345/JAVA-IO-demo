//import java.util.function.Consumer;

public class SynchronizedTests {

    private static Object object = null;

    public SynchronizedTests(Object o) {
        object = o;
    }

//    public static void main(String[] args) {
//        test((obj) -> {
//            //lambda表达式中 synchronized 必须指定监控对象
//            synchronized (SynchronizedTests.class) {
//
//            }
//        });
//        Object lock = new Object();
//        SynchronizedTests synchronizedTests = new SynchronizedTests(lock);
//        synchronizedTests.testInstance((obj) -> {
//            synchronized (synchronizedTests) {
//
//            }
//        });
//    }
//
//    private static void test(Consumer consumer){
//        consumer.accept(object);
//    }
//
//    private void testInstance(Consumer consumer){
//        consumer.accept(object);
//    }
}
