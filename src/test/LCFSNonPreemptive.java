package test;

import java.util.Stack;

public class LCFSNonPreemptive extends LCFS implements Scheduler {
    public LCFSNonPreemptive() {
        super.setCurrentTime(0);
        super.setStack(new Stack<Process>());
    }

    @Override
    public void schedule(ProcessClass[] processes) {
        System.out.println("test.LIFO Non Preemptive scheduling algorithm");
    }

}

