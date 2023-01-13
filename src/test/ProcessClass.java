package test;

public class ProcessClass {
    private static int processCounter = 0;

    private int id;
    private int arrivalTime;
    private int neededTime;
    final private int initNeeded;

    public ProcessClass(int arrivalTime, int burstTime) {
        this.id = processCounter++;
        this.arrivalTime = arrivalTime;
        this.initNeeded = burstTime;
        this.neededTime = burstTime;
    }

    public static void resetProcessCounter() {
        processCounter = 0;
    }

    public boolean isTerminated(){
        return neededTime==0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }

    public int getInitNeeded() {
        return this.initNeeded;
    }

}
