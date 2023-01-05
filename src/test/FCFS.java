package test;

import java.util.LinkedList;
import java.util.List;

public class FCFS extends AbstractScheduler implements Scheduler {
    public FCFS() {
        super.setCurrentTime(0);
    }


    @Override
    public void schedule(List<ProcessClass> processes) {
        double totalTurnAround = 0;
        List<ProcessClass> sortedProcesses = new LinkedList<>(processes);
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime()-p2.getArrivalTime());
        setCurrentTime(sortedProcesses.get(0).getArrivalTime());
        for(ProcessClass pc : sortedProcesses){
            setCurrentTime(getCurrentTime()+pc.getNeededTime());
            totalTurnAround+=getCurrentTime()- pc.getArrivalTime();
        }
        System.out.println("FCFS TurnAroundTime: "+ totalTurnAround/sortedProcesses.size());
    }
}

