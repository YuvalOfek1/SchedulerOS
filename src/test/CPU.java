package test;

import java.util.ArrayList;
import java.util.List;

public class CPU {
    List<ProcessClass> processes;
    public void run(Scheduler scheduler) {
        scheduler.schedule(this.processes);
    }
    public CPU(ProcessClass[] processes){
        this.processes = new ArrayList<>(List.of(processes));
    }
}
