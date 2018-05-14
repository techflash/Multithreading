package com.thread.concept.threadpool;

public class ThreadPoolMain {
    public static void main(String[] args) {
        MyBockingQueue<Integer> bockingQueue = new MyBockingQueue<>(5);

        for(int i=0; i < 6; i++){

            bockingQueue.enqueue(i);
            System.out.println("Enqueued : " + i);
        }
    }
}
