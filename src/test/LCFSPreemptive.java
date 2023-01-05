package test;

import java.util.Stack;

public class LifoPreemptive extends LIFO implements Scheduler {
    public LifoPreemptive() {
        super.setCurrentTime(0);
        super.setStack(new Stack<Process>());
    }

    @Override
    public void schedule(Process[] processes) {
        System.out.println("test.LIFO Preemptive scheduling algorithm");
    }
}

