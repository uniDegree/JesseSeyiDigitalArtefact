package ProcessManagerClass;

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
    FullTimeStudent fullTimeStudent = new FullTimeStudent();
    Student storeObjectType = null;
    public void manageProcess()
    {
        Scanner scanner = new Scanner(System.in);
        String userProceed = "";

        while (!userProceed.equals("N"))
        {
            String beginningPrompt = "Would you like to add a new student (S) or view an existing student's file (V)?";
            String continuationRequest = "\nWould you like to continue?";
            String readOrWriteChoice;

            do
            {
                System.out.println(beginningPrompt);
                readOrWriteChoice = scanner.nextLine().toUpperCase();
            } while(!readOrWriteChoice.equals("S") && !readOrWriteChoice.equals("V"));

            if (readOrWriteChoice.equals("S"))
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
                userProceed = continuationOrExit(continuationRequest, scanner);

                int userOption = 0;
                String menuProceed = "";
                String optionPrompt = "Please enter the option you would like to use below: (1-4)";
                while (!menuProceed.equals("N"))
                {
                    do
                    {
                        System.out.println("In this programme you have 4 choices:");
                        System.out.println("Option 1 - See "+ storeObjectType.getForename() + "'s age when their degree has finished");
                        System.out.println("Option 2 - Calculate " + storeObjectType.getForename() + "'s UCAS score");
                        System.out.println("Option 3 - See how many years it will take for " + storeObjectType.getForename() + " to reach retirement");

                        try
                        {
                            userOption = fullTimeStudent.getIntegerFromUser(optionPrompt, scanner);
                            scanner.nextLine();

                            if (userOption > 3)
                            {
                                throw new InvalidNumberException("This is invalid as it is above 3", userOption);
                            }
                            else if (userOption < 1)
                            {
                                throw new InvalidNumberException("This is invalid a is below 1", userOption);
                            }
                        }
                        catch(InvalidNumberException e)
                        {
                            System.err.println(e.getMessage());
                        }
                    } while (userOption < 1 || userOption > 3);

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
                    String menuContinuationRequest = "Would you like to see further information on " + storeObjectType.getForename() + " or would you like to leave this menu? (Y/N)";
                    menuProceed = continuationOrExit(menuContinuationRequest, scanner);
                }
                userProceed = continuationOrExit(continuationRequest, scanner);
            }

            if (readOrWriteChoice.equals("V"))
            {
                String readFileRequest = "Please enter the ID of the student you wish to access data for:";
                int studentId = -1;

                do
                {
                    try
                    {
                        studentId = fullTimeStudent.getIntegerFromUser(readFileRequest, scanner);
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
                userProceed = continuationOrExit(continuationRequest, scanner);
            }

        }
        System.out.println("\nThank you for using Seyi's StudentClasses.Student Record System");
    }

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
