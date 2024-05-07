package ProcessManagerClass;

//All the relevant classes from the packages are imported here along with the scanner.
import ReadFileClasses.ReadFullTimeStudentFile;
import ReadFileClasses.ReadOnlineStudentFile;
import ReadFileClasses.ReadPartTimeStudentFile;
import StudentClasses.FullTimeStudent;
import StudentClasses.OnlineStudent;
import StudentClasses.PartTimeStudent;
import StudentClasses.Student;
import StudentFurtherInformationClasses.AgeAfterDegree;
import StudentFurtherInformationClasses.UcasCalculator;
import StudentFurtherInformationClasses.YearsTillRetirement;
import CustomExceptions.InvalidNumberException;
import java.util.Scanner;

public class ProcessManager
{
    //This fullTimeStudent object is set here mainly to access the getIntegerFromUser method I made in the createStudent method within this class.
    FullTimeStudent fullTimeStudent = new FullTimeStudent();

    //This student object is used to store whether the user has selected a full-time, part-time or online student.
    //So it is declared null initially but is set to the appropriate class later on in the code once the user enters the
    //student they'd like to enter.
    Student storeObjectType = null;

    //This method is in charge of running the entire main menu of the system.
    public void manageProcess()
    {
        Scanner scanner = new Scanner(System.in);

        //This variable stores 'Y' or 'N' which when it equals 'N', the program stops running. When 'Y', the user can
        //keep using the program.
        String userProceed = "";

        //This loop keeps repeating until the user enters 'N'.
        while (!userProceed.equals("N"))
        {
            String beginningPrompt = "Would you like to add a new student (S) or view an existing student's file (V)?";
            String continuationRequest = "\nWould you like to continue (Y) or exit the program (N)?";

            //This choice variable is used to store 'S' for creating a new student file or "V" to read an existing student file.
            String readOrWriteChoice;

            //This do-while loop recurs until the user has entered 'S' or 'V' as their beginning choice.
            do
            {
                System.out.println(beginningPrompt);
                readOrWriteChoice = scanner.nextLine().toUpperCase();
            } while(!readOrWriteChoice.equals("S") && !readOrWriteChoice.equals("V"));

            //This if statement guides the user to enter student data if they chose to write a new student file ('S').
            if (readOrWriteChoice.equals("S"))
            {
                //This variable stores the number entered between 1-3.
                int studentType = 0;

                //These variables are the range 1-3 that the user must follow to enter what type of student they want to enter.
                int minStudentType = 1;
                int maxStudentType = 3;
                //This do-while loop keeps recurring until they enter a number between 1-3. If they enter a different datatype,
                //then the getIntegerFromUser method forces them to repeat the entry. Or, if they enter a number outside the range
                //a custom exception is thrown and they're also forced to repeat the entry.
                do
                {
                    try
                    {
                        String studentTypePrompt = "Which type of student are you entering?\n1. Full time student | 2. Part time student | 3. Online student";
                        studentType = fullTimeStudent.getIntegerFromUser(studentTypePrompt, scanner);
                        if (studentType < minStudentType)
                        {
                            throw new InvalidNumberException("This is invalid because it is below 1", studentType);
                        }
                        else if (studentType > maxStudentType)
                        {
                            throw new InvalidNumberException("This is invalid because it is above 3", studentType);
                        }
                    }
                    catch(InvalidNumberException e)
                    {
                        System.err.println(e.getMessage());
                    }
                }while (studentType < minStudentType || studentType > maxStudentType);

                //If 1 is entered, then storeObjectType is a fullTimeStudent object. If 2, then it is a partTimeStudent object
                //or finally, if it is 3, then it is an onlineStudent object.
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

                //The user is asked if they want to resume or leave the program using the continuationOrExit method below.
                scanner.nextLine();
                userProceed = continuationOrExit(continuationRequest, scanner);

                //This is used to store the menu option of 1-3.
                int userOption = 0;

                //This is used to store 'Y' or 'N' and this takes into account whether they want to continue finding out further
                //info on the student or not.
                String menuProceed = "";

                String optionPrompt = "Please enter the option you would like to use below: (1-3)";

                //While the user has not decided to leave this menu.
                while (!menuProceed.equals("N"))
                {
                    //These variables store the minimum and maximum value for the options that can be entered.
                    int minOption = 1;
                    int maxOption = 3;
                    //This do while loop recurs until the user has entered a number within the range of 1-3. If they enter a different datatype,
                    //then the getIntegerFromUser method forces them to repeat the entry. Or, if they enter a number outside the range
                    //a custom exception is thrown and they're also forced to repeat the entry.
                    do
                    {
                        System.out.println("In this programme you have 3 choices:");
                        System.out.println("Option 1 - See "+ storeObjectType.getForename() + "'s age when their degree has finished");
                        System.out.println("Option 2 - Calculate " + storeObjectType.getForename() + "'s UCAS score");
                        System.out.println("Option 3 - See how many years it will take for " + storeObjectType.getForename() + " to reach retirement");
                        try
                        {
                            userOption = fullTimeStudent.getIntegerFromUser(optionPrompt, scanner);
                            scanner.nextLine();
                            if (userOption > maxOption)
                            {
                                throw new InvalidNumberException("This is invalid as it is above 3", userOption);
                            }
                            else if (userOption < minOption)
                            {
                                throw new InvalidNumberException("This is invalid a is below 1", userOption);
                            }
                        }
                        catch(InvalidNumberException e)
                        {
                            System.err.println(e.getMessage());
                        }
                    } while (userOption < minOption || userOption > maxOption);

                    //If 1 is entered, the user gets to see how old the student will be when their degree is finished.
                    //If 2 is entered, the user gets to see the student's UCAS score based on their A-level grades.
                    //If 3 is entered, then the user gets to see how old the student till they reach retirement or how
                    //many years past it they are if they're older than 66.
                    switch (userOption)
                    {
                        case 1:
                            AgeAfterDegree ageAfterDegree = new AgeAfterDegree();
                            ageAfterDegree.userAgeAfterDegree(storeObjectType.getUserAge(), storeObjectType.getDegreeTimeLength(), storeObjectType.getForename(), storeObjectType.getDegreeName(), storeObjectType.getUniversityName());
                            break;
                        case 2:
                            UcasCalculator ucasCalculator = new UcasCalculator();
                            ucasCalculator.calculateUcasPoints(storeObjectType);
                            break;
                        case 3:
                            YearsTillRetirement yearsTillRetirement = new YearsTillRetirement();
                            yearsTillRetirement.retirementCountdown(storeObjectType);
                            break;
                        default:
                            break;
                    }

                    //This request asks the user if they're ready to continue using the menu or not.
                    String menuContinuationRequest = "Would you like to see further information on " + storeObjectType.getForename() + " (Y) or would you like to leave this menu (N)?";
                    menuProceed = continuationOrExit(menuContinuationRequest, scanner);
                }
                //Once again the user is asked if they want to quit the program or not.
                userProceed = continuationOrExit(continuationRequest, scanner);
            }

            //This option is present for the user who wants to view student data.
            if (readOrWriteChoice.equals("V"))
            {
                //The user has to enter the system generated student ID for the user they wish to look at.
                String readFileRequest = "Please enter the ID of the student you wish to access data for:";
                int studentId = -1;

                //Variables store the minimum and maximum number a user can enter for the student ID.
                int minStudentType = 0;
                int maxStudentType = 1_000_000;

                //This do-while loop keeps repeating until the user has entered is not outside the range 0-1,000,000. If they enter a different datatype,
                //then the getIntegerFromUser method forces them to repeat the entry. Or, if they enter a number outside the range
                //a custom exception is thrown and they're also forced to repeat the entry. Furthermore if they enter an ID that doesn't exist,
                //they are also thrown a custom exception which tells them this does not exists and returns them to the starting poing of the system.
                do
                {
                    try
                    {
                        studentId = fullTimeStudent.getIntegerFromUser(readFileRequest, scanner);
                        scanner.nextLine();

                        if(studentId < minStudentType)
                        {
                            throw new InvalidNumberException("This is invalid as the student ID entered was less than 0", studentId);
                        }

                        else if(studentId > maxStudentType)
                        {
                            throw new InvalidNumberException("This is invalid as the student ID entered ID was more than 1,000,000", studentId);

                        }
                        Student foundStudent = ReadFullTimeStudentFile.AccessStudentData(studentId);
                        if(foundStudent == null)
                        {
                            throw new InvalidNumberException("This is invalid because the student file was not found", studentId);
                        }

                        //Once it gets past the checks the software needs to find out which type of student was entered so that it can read it properly.
                        //So it uses findOccupation method made in the Student abstract class to find this. If it is found to be a part-time student then
                        //it will output the result as a part-time student including the daysInAWeek mention. If it is online student, then it is read
                        //as an online student and displays the onlinePlatform used. Otherwise, it is a generic full-time student, so it reads the usual details.
                        String occupationCheck = foundStudent.findOccupation();
                        if(occupationCheck.equals("Part-time student"))
                        {
                            Student foundPartTime = ReadPartTimeStudentFile.AccessStudentData(studentId);
                            foundPartTime.printGeneralDetails();
                            foundPartTime.printPartTimeStudentDetail();
                        }
                        else if (occupationCheck.equals("Online student"))
                        {
                            Student foundOnline = ReadOnlineStudentFile.AccessStudentData(studentId);
                            foundOnline.printGeneralDetails();
                            foundOnline.printOnlineStudentDetail();
                        }
                        else
                        {
                            foundStudent.printGeneralDetails();
                        }

                        //The user is asked whether they want to continue or leave the program using the continuationOrExit method.
                        userProceed = continuationOrExit(continuationRequest, scanner);
                    }
                    catch(InvalidNumberException e)
                    {
                        System.err.println(e.getMessage());
                    }
                } while(studentId < minStudentType || studentId > maxStudentType);
            }
        }
        //This is the final printed statement the user will see before they exit the program.
        System.out.println("\nThank you for using Seyi's Student Record System");
    }

    //This method takes the message request (prompt) and the scanner and keeps repeating until the user has entered 'Y' or 'N' and then it returns this value.
    //This was made to be a method because I needed to use it multiple times throughout the code and it saved me some code lines.
    public String continuationOrExit(String request, Scanner scanner)
    {
        String proceed;
        do
        {
            System.out.println(request);
            proceed = scanner.nextLine().toUpperCase();
        } while (!proceed.equals("Y") && !proceed.equals("N"));

        return proceed;
    }
}
