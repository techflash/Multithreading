package com.thread.concept.threadpool;

import java.util.LinkedList;

public class MyBockingQueue<T> {
    private LinkedList<T> queue;
    private int size;

    public MyBockingQueue(Integer size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public void enqueue(T t) {
        synchronized (queue) {

            while (size == queue.size()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }

            queue.addLast(t);
            queue.notify();
        }
    }

    public T dequeue() {
        T t = null;
        synchronized (queue) {

            while (queue.size() < 1) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }

            t = queue.removeFirst();
            queue.notify();
        }
        return t;
    }

}
