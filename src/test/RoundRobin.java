package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RoundRobin extends AbstractScheduler implements Scheduler {

    private int timeQuantum;
    public RoundRobin(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        super.setCurrentTime(0);
    }

    @Override
    public void schedule(List<ProcessClass> processes) {
        double totalTurnAround = 0;
        boolean changed; //added
        List<ProcessClass> sortedProcesses = new LinkedList<>(processes);
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime()-p2.getArrivalTime());
        Set<Integer> terminatedProcessesIDS = new HashSet<>();
        setCurrentTime(sortedProcesses.get(0).getArrivalTime());

        while(terminatedProcessesIDS.size() != sortedProcesses.size()){
            changed = false; //added
            for(ProcessClass pc : sortedProcesses){

                ///added/////////////////////////////////////
                if(pc.isTerminated()) {
                    terminatedProcessesIDS.add(pc.getId());
                    continue;
                }
                ///////////////////////////////////////////////////////

                if(!pc.isTerminated() && pc.getArrivalTime()<= getCurrentTime()){
                    changed=true; //added
                    setCurrentTime(getCurrentTime()+Math.min(pc.getNeededTime(), timeQuantum));
                    pc.setNeededTime(pc.getNeededTime()-Math.min(pc.getNeededTime(), timeQuantum));
                    if(pc.isTerminated()){
                        totalTurnAround+= getCurrentTime()-pc.getArrivalTime();
                        terminatedProcessesIDS.add(pc.getId());
                    }
                }
            }

            //added//////////////////////////////////
            if(!changed)
                setCurrentTime(getCurrentTime()+1);
            //////////////////////////////////////////
        }
        System.out.println("Round Robin AVG TurnAroundTime: " + (totalTurnAround/sortedProcesses.size()));



    }
}

