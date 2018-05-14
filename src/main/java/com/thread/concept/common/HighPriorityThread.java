package com.thread.concept.common;

/**
 * Creating thread this way essentially says that a class is itself a thread.
 * And wants to customize the way a java thread runs and terminate.
 * For example if I want to create a Thread which always creates thread with
 * Highest priority then I can extend an customize this behaviour
 */
public class HighPriorityThread extends Thread {
    private String name;

    public HighPriorityThread(String name){
        super(name);
        this.setPriority(Thread.MAX_PRIORITY);
        this.name = name;
    }

    @Override
    public void run() {

        // Perform some task
    }
}
