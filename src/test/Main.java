package test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("src/test/input1.txt")));
            ArrayList<ProcessClass> al = new ArrayList<>();

            int numOfProcesses = Integer.parseInt(scan.nextLine());
            for(int i=0;i<numOfProcesses;i++){
                String line = scan.nextLine();
                String[] processData = line.split(",");
                ProcessClass pc = new ProcessClass(Integer.parseInt(processData[0]), Integer.parseInt(processData[1]));
                al.add(pc);
            }
            System.out.println("<------Input1.txt-------->");
            CPU cpu = new CPU(al);
            cpu.run(new RoundRobin(2));
            cpu.setProcesses(al);
            cpu.run(new FCFS());
            cpu.setProcesses(al);
            cpu.run(new LCFSNonPreemptive());
            cpu.setProcesses(al);
            cpu.run(new LCFSPreemptive());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}