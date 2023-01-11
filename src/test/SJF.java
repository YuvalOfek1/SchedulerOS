package test;

import java.util.*;

public class SJF extends AbstractScheduler implements Scheduler {
    private Queue<ProcessClass> pq;

    public SJF() {
        pq = new PriorityQueue<>((p1, p2) -> p1.getInitNeeded() - p2.getInitNeeded());
    }

    @Override
    public void schedule(List<ProcessClass> processes) {
        double totalTurnAround = 0;
        boolean changed; //added
        List<ProcessClass> sortedProcesses = new LinkedList<>(processes);
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime()-p2.getArrivalTime());
        Set<Integer> terminatedProcessesIDS = new HashSet<>();
        Set<Integer> processInPq = new HashSet<>(); // id
        int currentProcessIndex = 0;
        setCurrentTime(sortedProcesses.get(currentProcessIndex).getArrivalTime());
        pq.add(sortedProcesses.get(currentProcessIndex));
        currentProcessIndex++;

        while(terminatedProcessesIDS.size() < processes.size()) {

            if(currentProcessIndex < sortedProcesses.size()) {
                // add to pq
                if(pq.isEmpty()) {
                    setCurrentTime(sortedProcesses.get(currentProcessIndex).getArrivalTime());
                    pq.add(sortedProcesses.get(currentProcessIndex));
                    currentProcessIndex++;
                }
                int tempCurrentTime = sortedProcesses.get(currentProcessIndex).getArrivalTime();
                int timePassed = tempCurrentTime - getCurrentTime();
                if(pq.peek().getNeededTime() - timePassed > 0) {
                    ProcessClass lastProcess = pq.poll();
                    lastProcess.setNeededTime(lastProcess.getNeededTime() - timePassed);
                    pq.add(lastProcess);
                    pq.add(sortedProcesses.get(currentProcessIndex));
                    currentProcessIndex++;
                    setCurrentTime(tempCurrentTime);
                }else {
                    ProcessClass lastProcess = pq.poll();
                    totalTurnAround += getCurrentTime() + lastProcess.getNeededTime() - lastProcess.getArrivalTime();
                    setCurrentTime(getCurrentTime() + lastProcess.getNeededTime());
                    lastProcess.setNeededTime(0);
                    terminatedProcessesIDS.add(lastProcess.getId());
//                    pq.add(sortedProcesses.get(currentProcessIndex));
//                    currentProcessIndex++;
//                    setCurrentTime(tempCurrentTime);
                }


            }else {
                while(!pq.isEmpty()) {
                    ProcessClass lastProcess = pq.poll();
                    setCurrentTime(getCurrentTime() + lastProcess.getNeededTime());
                    lastProcess.setNeededTime(0);
                    terminatedProcessesIDS.add(lastProcess.getId());
                    totalTurnAround += getCurrentTime() - lastProcess.getArrivalTime();
                }
            }

        }

        System.out.println("SJF AVG turn around time: " + totalTurnAround / sortedProcesses.size());
    }
}

