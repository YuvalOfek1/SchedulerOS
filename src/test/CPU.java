package test;

public class CPU {

    public void run(Scheduler scheduler, ProcessClass[] processes) {
        scheduler.schedule(processes);
    }
}
