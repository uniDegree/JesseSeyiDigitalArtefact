package MainClass;
//The ProcessManagerClass package is imported to run this part of the code.
import ProcessManagerClass.ProcessManager;

public class Main
{
    public static void main(String[] args)
    {
        //Calls the manageProcess method from the ProcessManager class.
        ProcessManager processManager = new ProcessManager();
        processManager.manageProcess();
    }
}
