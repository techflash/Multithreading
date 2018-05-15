package com.thread.concept.threadpool;

import java.util.HashSet;
import java.util.Set;

public class MyExecutorService {
    private int poolSize;
    private MyBockingQueue<Runnable> queue;
    private Set<Thread> threadPool;
    private volatile boolean shutdown = false;

    public MyExecutorService() {
        this(1);
    }

    public MyExecutorService(int poolSize) {
        this.poolSize = poolSize;
        queue = new MyBockingQueue<>(this.poolSize);
        threadPool = new HashSet<>();
        createWorkers(poolSize);
    }

    private void createWorkers(int workerCount) {
        for (int i = 0; i < workerCount; i++) {
            threadPool.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!shutdown) {
                        Runnable task = queue.dequeue();
                        task.run();
                    }
                }
            }));

        }
        threadPool.stream().forEach(thread -> thread.start());
    }

    public void submit(Runnable task) {
        queue.enqueue(task);
    }

    public void shutdown() {
        this.shutdown = true;
    }

    public void await() {
        threadPool.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
