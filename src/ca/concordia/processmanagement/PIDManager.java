package ca.concordia.processmanagement;

import ca.concordia.processmanagement.exceptions.MapAllocationException;
import ca.concordia.processmanagement.exceptions.PIDAllocationException;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PIDManager {
    static final int MIN_PID = 300;
    static final int MAX_PID = 500;
    private int[] PIDArray;
    private boolean[] PIDAvailability;
    PIDManager(){
        try{   this.allocateMap(); }
        catch(MapAllocationException e){
            System.out.println(e);
        }

    }
    void allocateMap()throws MapAllocationException {

        if(this.PIDArray == null && this.PIDAvailability == null){
            this.PIDArray = new int[200];
            this.PIDAvailability = new boolean[200];
            PIDArray = IntStream.range(MIN_PID,MAX_PID).toArray();
            Arrays.fill(PIDAvailability,true);
        } else{
            throw new MapAllocationException("PID Map has already been allocated");
        }


    }
    int allocatePid() throws PIDAllocationException {
        if(this.PIDArray == null && this.PIDAvailability == null){
            throw new PIDAllocationException("No PID Map Allocated");
        } else;
        int length = PIDArray.length;
        for (int i = 0; i < length; i++ ) {
            if(this.PIDAvailability[i]){
                this.PIDAvailability[i] = false;
                return PIDArray[i];
            }else continue;
        }
        throw new PIDAllocationException("No Available PID");
    }
    void releasePid(int pid){
        int PIDIndex = Arrays.binarySearch(this.PIDArray,pid);
        this.PIDAvailability[PIDIndex] = true;
        //use math method instead? we could just do like pid - 300 = index
    }

}
