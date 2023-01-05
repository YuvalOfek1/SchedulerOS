package test;

import java.util.*;

public class LCFSNonPreemptive extends LCFS implements Scheduler {

    public LCFSNonPreemptive() {
        super.stack = new Stack<>();
    }


    @Override
    public void schedule(List<ProcessClass> processes) {
        double totalTurnAround = 0;
        Set<Integer> terminatedProcessesIDS = new HashSet<>();
        List<ProcessClass> sortedProcesses = new LinkedList<>(processes);
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime()-p2.getArrivalTime());
        setCurrentTime(sortedProcesses.get(0).getArrivalTime());
        while(terminatedProcessesIDS.size()<sortedProcesses.size()){
            for(ProcessClass p : sortedProcesses){
                if(p.getArrivalTime()<=getCurrentTime() && !p.isTerminated()){
                    super.addToStack(p);
                }
            }
            ProcessClass p = super.stack.pop();
            setCurrentTime(getCurrentTime()+p.getNeededTime());
            p.setNeededTime(0);
            totalTurnAround+=getCurrentTime()-p.getArrivalTime();
            terminatedProcessesIDS.add(p.getId());

        }
        System.out.println("LCFS Non-Preemtive: " + totalTurnAround/sortedProcesses.size());
    }
}

