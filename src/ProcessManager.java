import java.util.Scanner;
public class ProcessManager
{
    Student storeObjectType = null;

    public void manageProcess()
    {
        FullTimeStudent fullTimeStudent = new FullTimeStudent();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add a new student (S) or view an existing student's file (V)");
        String choice = scanner.nextLine().toUpperCase();
        if (choice.equals("S"))
        {
            String studentTypePrompt = "\nWhich type of student are you entering?\n1. Full time student | 2. Part time student | 3. Online student";

            int studentType = fullTimeStudent.getIntegerFromUser(studentTypePrompt, scanner);
            scanner.nextLine();
            while (studentType < 1 || studentType > 3)
            {
                System.out.println("outside of range");
                studentType = fullTimeStudent.getIntegerFromUser(studentTypePrompt, scanner);
                scanner.nextLine();
            }
            switch(studentType)
            {
                case 1:
                    storeObjectType = new FullTimeStudent();
                    storeObjectType.createStudent();
                    storeObjectType.studentOccupation(studentType);
                    break;
                case 2:
                    storeObjectType = new PartTimeStudent();
                    storeObjectType.createStudent();
                    storeObjectType.studentOccupation(studentType);
                    break;
                case 3:
                    storeObjectType = new OnlineStudent();
                    storeObjectType.createStudent();
                    storeObjectType.studentOccupation(studentType);
                    break;
            }
        }
    }
}
