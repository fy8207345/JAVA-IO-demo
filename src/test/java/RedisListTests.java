import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisList;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisListTests {

    public static void main(String[] args) {
        RedisTemplate<String, Runnable> redisTemplate = new RedisTemplate<>();
        DefaultRedisList<Runnable> runnables = new DefaultRedisList<>("test", redisTemplate);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 8, 60, TimeUnit.SECONDS, runnables);
    }
}
