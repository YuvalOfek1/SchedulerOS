package test;

import java.util.List;
import java.util.Stack;

public class LCFSNonPreemptive extends LCFS implements Scheduler {
    public LCFSNonPreemptive() {
        super.setCurrentTime(0);
        super.setStack(new Stack<Process>());
    }


    @Override
    public void schedule(List<ProcessClass> processes) {

    }
}

