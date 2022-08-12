import java.util.concurrent.TimeUnit;

public class LeakMain {
    public static void main(String[] args) throws InterruptedException {
        SwissCheese swissCheese = new SwissCheese();
        TimeUnit.HOURS.sleep(1);
    }
}
