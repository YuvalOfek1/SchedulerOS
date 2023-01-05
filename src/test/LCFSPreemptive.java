package test;

import java.util.*;

public class LCFSPreemptive extends LCFS implements Scheduler {
    public LCFSPreemptive() {
        super.stack = new Stack<>();
    }

    @Override
    public void schedule(List<ProcessClass> processes) {
        double totalTurnAround = 0;
        Set<Integer> terminatedProcessesIDS = new HashSet<>();
        List<ProcessClass> sortedProcesses = new LinkedList<>(processes);
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime()-p2.getArrivalTime());
        setCurrentTime(sortedProcesses.get(0).getArrivalTime());
        int lastProcess = 0;
        while(terminatedProcessesIDS.size()<sortedProcesses.size()){

            if(sortedProcesses.size()>lastProcess) {
                if(!sortedProcesses.get(lastProcess).isTerminated() && sortedProcesses.get(lastProcess).getArrivalTime()<=getCurrentTime()) {

                    super.addToStack(sortedProcesses.get(lastProcess));
                    lastProcess++;
                }
            }
            ProcessClass p = stack.pop();
            int tempTime = getCurrentTime()+p.getNeededTime();
            if(lastProcess == sortedProcesses.size()){
                setCurrentTime(getCurrentTime()+p.getNeededTime());
                p.setNeededTime(0);
                totalTurnAround+=getCurrentTime()-p.getArrivalTime();
                terminatedProcessesIDS.add(p.getId());
            }
            else if(sortedProcesses.get(lastProcess).getArrivalTime() <= tempTime && !sortedProcesses.get(lastProcess).isTerminated()){
                int toReduce = sortedProcesses.get(lastProcess).getArrivalTime()-getCurrentTime();
                p.setNeededTime(p.getNeededTime()-toReduce);
                setCurrentTime(getCurrentTime()+toReduce);
                stack.add(p);
            }

        }

        System.out.println("LCFS Preemtive TurnAroundTime: " + totalTurnAround/sortedProcesses.size());
    }
}

