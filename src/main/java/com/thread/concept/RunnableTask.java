package com.thread.concept;

import com.thread.concept.common.Task;

public class RunnableTask {
    public static void main(String[] args) {
        Task.Step steps[] = {Task.Step.INITIALISE, Task.Step.PROCESS};
        Thread thread = new Thread(new Task(steps));
    }

}
