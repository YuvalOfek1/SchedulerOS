package test;

import java.util.ArrayList;
import java.util.List;

public class CPU {
    List<ProcessClass> processes;
    public void run(Scheduler scheduler) {
        scheduler.schedule(this.processes);
    }
    public CPU(List<ProcessClass> processes){
        this.processes = new ArrayList<>();
        this.setProcesses(processes);
    }

    public void setProcesses(List<ProcessClass> processes){
        this.processes.clear();
        for(ProcessClass p:processes){
            this.processes.add(new ProcessClass(p.getArrivalTime(), p.getNeededTime()));
        }
    }
}
