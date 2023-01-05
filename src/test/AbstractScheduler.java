package test;

import java.util.List;

public abstract class AbstractScheduler {
    private int currentTime;
    public abstract void schedule(List<ProcessClass> processes);
    public int getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}

