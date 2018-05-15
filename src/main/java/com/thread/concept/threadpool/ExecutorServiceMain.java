package com.thread.concept.threadpool;

import java.util.Scanner;

public class ExecutorServiceMain {
    public static void main(String[] args) {

        MyExecutorService executorService = new MyExecutorService(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " is worked upon ..");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " has completed execution.. ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Scanner sc = new Scanner(System.in);
        System.out.println("Press any key to exit");
        sc.nextLine();
        executorService.shutdown();


    }
}
