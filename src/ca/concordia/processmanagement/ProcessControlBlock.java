package ca.concordia.processmanagement;

import ca.concordia.processmanagement.exceptions.PIDAllocationException;

public class ProcessControlBlock {
    private int PID;
    private String processStatus = "unnalocated";
    ProcessControlBlock(PIDManager PIDS){
        try{
            this.PID = PIDS.allocatePid();
            this.processStatus = "ready";
        }
        catch(PIDAllocationException e){
            System.out.println(e);
        };
    }
    public String getProcessStatus(){
        return this.processStatus;
    }
    public int getPID(){
        return this.PID;
    }
}
