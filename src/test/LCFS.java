package test;

import java.util.List;
import java.util.Stack;

public abstract class LCFS extends AbstractScheduler implements Scheduler {
    protected Stack<ProcessClass> stack;

    public void addToStack(ProcessClass process) {
        this.stack.push(process);
    }
}
