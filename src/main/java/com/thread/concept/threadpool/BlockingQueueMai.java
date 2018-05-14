package com.thread.concept.threadpool;

public class BlockingQueueMai {

    public static void main(String[] args) {
        MyBockingQueue<Integer> bockingQueue = new MyBockingQueue<>(5);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    bockingQueue.enqueue(++i);
                    System.out.println("Enqueued: " + i);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Integer i = bockingQueue.dequeue();
                    System.out.println("Dequeued : " + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();

            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
