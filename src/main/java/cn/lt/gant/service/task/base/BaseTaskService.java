package cn.lt.gant.service.task.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 任务Service
 *
 *
 * @author lt
 * @version 1.0.0
 */
public abstract class BaseTaskService {

    /**
     * Redis缓存
     */

    /**
     * 执行任务
     */
    public void run() {

        // 子类的Class
        Class<?> subClass = this.getSubClass();

        // 日志记录器
        Logger logger = LoggerFactory.getLogger(subClass);

        // 任务ID
        final String LOCK_KEY = "task:" + subClass.getName();

        // 保证同一个任务只被执行一次
        if (isLocked(LOCK_KEY)) {
            return;
        }

        try {
            lockup(LOCK_KEY);
            logger.info("task running...");
            // 执行业务逻辑
            execute();
            logger.info("task successful.");
        } catch (Throwable e) {
            logger.error("task failure,{}", e);
        } finally {
            unlock(LOCK_KEY);
        }
    }

    /**
     * 同一个任务是否被锁上
     *
     * @param key
     * @return
     */
    protected boolean isLocked(final String key) {
        return false;//redis.exists(key);
    }

    /**
     * 给任务上锁(1分钟)
     *
     * @param key
     * @return
     */
    protected void lockup(final String key) {
        //redis.set(key, "true", 60);
    }

    /**
     * 解锁任务
     *
     * @param key
     * @return
     */
    protected void unlock(final String key) {
        //redis.del(key);
    }

    /**
     * 具体业务逻辑请重写此方法
     *
     * @throws Throwable
     */
    protected abstract void execute() throws Throwable;

    /**
     * 获取子类的Class
     *
     * @return
     */
    protected abstract Class<?> getSubClass();

}
