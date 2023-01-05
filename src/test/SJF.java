public class SJF extends AbstractScheduler implements Scheduler {
    public SJF() {
        super.setCurrentTime(0);
    }

    @Override
    public void schedule(Process[] processes) {
        System.out.println("Shortest Job First scheduling algorithm");
    }
}

