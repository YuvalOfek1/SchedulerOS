package test;

import java.util.Stack;

public class LifoNonPreemptive extends LIFO implements Scheduler {
    public LifoNonPreemptive() {
        super.setCurrentTime(0);
        super.setStack(new Stack<Process>());
    }

    @Override
    public void schedule(Process[] processes) {
        System.out.println("test.LIFO Non Preemptive scheduling algorithm");
    }
}

