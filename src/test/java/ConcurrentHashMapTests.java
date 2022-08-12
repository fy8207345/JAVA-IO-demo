import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapTests {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(32, 0.1f, 32);
        map.put("key", "value");

        Thread thread1 = new Thread(getRunnable(map));
        Thread thread2 = new Thread(getRunnable(map));

        thread1.start();
        thread2.start();

    }

    private static Runnable getRunnable(final ConcurrentMap<String, String> map){
        return new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    if(map.containsKey("key")){
                        String value = map.remove("key");
                        if(value == null){
                            System.out.println("" + i + ": value is null");
                        }
                    }else{
                        map.put("key", "value");
                    }
                }
            }
        };
    }
}
