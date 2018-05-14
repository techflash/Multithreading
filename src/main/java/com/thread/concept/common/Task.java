package com.thread.concept.common;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    public enum Step{
        INITIALISE,
        PROCESS,
        TERMINATE
    }

    private Step[] steps;

    /**
     * Step to perform
     *
     * @param steps
     */
    public Task(Step[] steps){
        this.steps = steps;
    }

    @Override
    public void run() {
        Arrays.stream(this.steps).forEach(step->{
            try {
                performStep(step);
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void performStep(Step step){
        System.out.println("Performing " + step.name());
    }
}
