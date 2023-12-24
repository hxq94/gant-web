package threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolSupport {

    @Bean(name = "hyfThreadPoolExecutor")
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(1);
        threadPoolExecutor.setMaxPoolSize(1);
        threadPoolExecutor.setQueueCapacity(2);
        threadPoolExecutor.setThreadNamePrefix("hyf-");
        return threadPoolExecutor;
    }

}
