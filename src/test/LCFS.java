package test;

import java.util.Stack;

public abstract class LCFS extends AbstractScheduler implements Scheduler {
    private Stack<Process> stack;

    public void setStack(Stack<Process> stack) {
        this.stack = stack;
    }
}
