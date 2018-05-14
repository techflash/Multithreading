package com.thread.concept.producer.consumer;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sharedResource.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
