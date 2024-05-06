import java.util.InputMismatchException;
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
            String studentTypePrompt = "Which type of student are you entering?\n1. Full time student | 2. Part time student | 3. Online student";

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
        else if (choice.equals("V"))
        {

            String readFileRequest = "Please enter the ID of the student you wish to access data for:";
            int studentId = -1;

            do
            {
                try
                {
                    FullTimeStudent fullTimeStudent1 = new FullTimeStudent();
                    studentId = fullTimeStudent1.getIntegerFromUser(readFileRequest, scanner);
                    scanner.nextLine();

                    if(studentId < 0)
                    {
                        throw new InvalidNumberException("This is invalid as the student ID entered was less than 0", studentId);
                    }

                    else if(studentId > 1_000_000)
                    {
                        throw new InvalidNumberException("This is invalid as the student ID entered ID was more than 1,000,000", studentId);

                    }
                }
                catch(InvalidNumberException e)
                {
                    System.err.println(e.getMessage());
                }
            } while(studentId < 0 || studentId > 1_000_000);

            Student foundStudent = ReadFullTimeStudentFile.AccessStudentData(studentId);

            String occupationCheck = foundStudent.printOccupation();
            if(occupationCheck.equals("part-time student"))
            {
                Student foundPartTime = ReadPartTimeStudentFile.AccessStudentData(studentId);
                foundPartTime.printGeneralDetails();
                foundPartTime.printPartTimeStudentDetail();
            }
            else if (occupationCheck.equals("online student"))
            {
                Student foundOnline = ReadOnlineStudentFile.AccessStudentData(studentId);
                foundOnline.printGeneralDetails();
                foundOnline.printOnlineStudentDetail();
            }
            else
            {
                foundStudent.printGeneralDetails();
            }
        }
    }
}
