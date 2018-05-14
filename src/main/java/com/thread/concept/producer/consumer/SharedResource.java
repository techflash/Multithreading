package com.thread.concept.producer.consumer;

import java.util.LinkedList;

public class SharedResource {
    private final Integer LIMIT = 10;
    private LinkedList<Integer> list = new LinkedList<>();
    private Object lock = new Object();

    public SharedResource() {

    }

    public void produce() throws InterruptedException {
        int i = 0;
        while (true) {

            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }

                list.add(++i);

                System.out.println(Thread.currentThread().getName() + " Produced : " + i);
                lock.notify();
                Thread.sleep(1);

            }
        }
    }

    public void consume() throws InterruptedException {

        while (true) {
            synchronized (lock) {
                while (list.size() < 1) {
                    lock.wait();
                }

                int i = list.removeFirst();
                System.out.println(Thread.currentThread().getName() + " Consumed : " + i);

                lock.notify();
                Thread.sleep(1);
            }
        }

    }


}
