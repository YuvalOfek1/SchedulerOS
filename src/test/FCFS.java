public class FCFS extends AbstractScheduler implements Scheduler {
    public FCFS() {
        super.setCurrentTime(0);
    }

    @Override
    public void schedule(Process[] processes) {
        System.out.println("First Come First Serve scheduling algorithm");
    }
}

