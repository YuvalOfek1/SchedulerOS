package test;

import java.util.List;

public class SJF extends AbstractScheduler implements Scheduler {
    public SJF() {
        super.setCurrentTime(0);
    }

    @Override
    public void schedule(List<ProcessClass> processes) {

    }
}

