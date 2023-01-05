package test;

public abstract class AbstractScheduler {
    private int currentTime;
    public abstract void schedule(ProcessClass[] processes);
    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}

