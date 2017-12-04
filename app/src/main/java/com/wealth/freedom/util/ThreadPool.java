package com.wealth.freedom.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: vavaldi
 * Time:  2017/12/4
 * Describe:
 */

public class ThreadPool {

    private static class ThreadPoolHolder {
        private static ThreadPool threadPool = new ThreadPool();
    }

    private ExecutorService pool;

    private ThreadPool() {
        if (pool == null) {
            LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
            pool = new ThreadPoolExecutor(7, 12, 10 * 1000L, TimeUnit.MILLISECONDS, blockingQueue);
        }
    }

    public static ExecutorService getInstance() {
        return ThreadPoolHolder.threadPool.pool;
    }

}

