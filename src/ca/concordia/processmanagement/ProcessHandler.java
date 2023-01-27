package ca.concordia.processmanagement;

import ca.concordia.processmanagement.exceptions.ProcessCreationException;
import ca.concordia.processmanagement.exceptions.ProcessDeletionException;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ProcessHandler implements ProcessOperationHandler{
    private PIDManager PIDS ;
    private LinkedHashMap<Integer,ProcessControlBlock> readyQueue ;
    public ProcessHandler(){
        this.PIDS= new PIDManager();
        this.readyQueue = new LinkedHashMap<>(201,1);
    }
    public int createProcess() throws ProcessCreationException{
         ProcessControlBlock PCB = new ProcessControlBlock(this.PIDS);

        if(PCB.getProcessStatus() == "ready"){
            this.readyQueue.put( PCB.getPID(),PCB);
            System.out.print("PID used: "+PCB.getPID()+" |");
            return PCB.getPID();
        }else throw new ProcessCreationException("Failed to create Process");
    }

    public void terminateProcess(int pid) throws ProcessDeletionException{
        if(this.readyQueue.containsKey(pid)){
            this.readyQueue.remove(pid);
            this.PIDS.releasePid(pid);
        }
        else throw new ProcessDeletionException("Ready Queue does not contain passed PID");

    }
    
}
