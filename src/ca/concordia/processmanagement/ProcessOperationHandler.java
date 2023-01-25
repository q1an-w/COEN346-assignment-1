package ca.concordia.processmanagement;

public interface ProcessOperationHandler {

    int createProcess() throws Exception;

    void terminateProcess(int pid) throws Exception;

}
