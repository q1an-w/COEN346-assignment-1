import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import ca.concordia.processmanagement.ProcessHandler;


public class Main {
    private static ProcessHandler processHandler;
    public static void create200Processes(){
        for(int i = 0; i < 200; i++){
            try {
                processHandler.createProcess();
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
    public static void createXProcesses(){

        System.out.println("How many processes would you like to create");

        int i;
        Scanner x = new Scanner(System.in);
        i = x.nextInt();
        if(i<0){
            System.out.println("Choose a positive number");
            return;
        }
        //no negative or >200
        for(int k = 0; k < i; k++){
            try {
                processHandler.createProcess();
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
    public static void createSingleProcess(){
        try {
            processHandler.createProcess();
            System.out.println();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void removeSingleProcess(){
        System.out.println("Enter PID of Process to terminate");

        int pid;
        Scanner x = new Scanner(System.in);
        pid = x.nextInt();
        try {
            processHandler.terminateProcess(pid);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void menu(){
        System.out.println("----------------------------------");
        System.out.println("1. Create single process");
        System.out.println("2. Remove single process");
        System.out.println("3. Create 200 new processes");
        System.out.println("4. Create x number of new processes");
        System.out.println("5. Exit Process Handler");
        System.out.print("input: ");

        int input;
        Scanner S = new Scanner(System.in);
        input = S.nextInt();

        switch(input) {
            case 1:
                createSingleProcess();
                menu();
                break;

            case 2:
                removeSingleProcess();
                menu();
                break;

            case 3:
                create200Processes();
                menu();
                break;

            case 4:
                createXProcesses();
                menu();
                break;
            case 5:
                System.out.println("Thank you for using our Process Handler");
                break;
        }
    };
    public static void main(String[] args) {
        processHandler = new ProcessHandler();
        menu();
    }
}
