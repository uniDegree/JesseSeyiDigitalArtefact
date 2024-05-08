package StudentClasses;

//All the relevant classes are imported from their appropriate packages.
import WriteFileClasses.WriteFullTimeStudentFile;
import CustomExceptions.InvalidNumberException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

//This class inherits from the Student Class.
public class FullTimeStudent extends Student
{
    //These validation messages are made global so that they can be used they can be used by other classes too.
    String characterLengthCheckValidationMessage = "This entered field is above the given character limit, try again below\n";
    String dataTypeCheckValidationMessage =  "This is not a valid integer, try again below:\n";

    @Override
    public void createStudent()
    {
        String forenameEntryRequest = "Please enter their first name (50 characters max):";

        int forenameAndSurnameAndSubjectNameLength = 50;
        int universityAndDegreeNamesLength = 100;
        int studentIdLength = 10;

        //This do-while loop keeps repeating until the forename entered is not left null, and it is not above 50 characters.
        //Once it has met these criteria, it is stored in the private forename variable using the setter I made in the Student class.
        do
        {
            System.out.println(forenameEntryRequest);
            setForename(scanner.nextLine());

            while(getForename().length() >forenameAndSurnameAndSubjectNameLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(forenameEntryRequest);
                setForename(scanner.nextLine());
            }
        } while(getForename().isEmpty());

        //This do-while loop keeps repeating until the surname entered is not left null, and it is not above 50 characters.
        //Once it has met these criteria, it is stored in the private surname variable using the setter I made in the Student class.
        String surnameEntryRequest = "Please enter " + getForename() +"'s surname (50 characters max):";
        do
        {
            System.out.println(surnameEntryRequest);
            setSurname(scanner.nextLine());

            while(getSurname().length() >forenameAndSurnameAndSubjectNameLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(surnameEntryRequest);
                setSurname(scanner.nextLine());
            }
        } while(getSurname().isEmpty());

        //This stores the name of the entered A-level subject before it is put into an array.
        String aLevelSubjectName;

        int minALevelAmount = 3;
        int maxALevelAmount = 5;
        String aLevelNumberRequest = "Please enter the number of A-Levels " + getForename() + " took in college (3-5):";
        int aLevelAmount;

        //This do-while loop keeps repeating until the aLevelAmount entered is within the range of 3-5.
        //It uses the getIntegerFromUser method to ensure an integer is entered.
        //From there it uses custom exceptions to ensure that the amount entered is not above or below the given range
        //of 3-5.
        do
        {
            aLevelAmount = getIntegerFromUser(aLevelNumberRequest, scanner);
            try
            {
                if(aLevelAmount < minALevelAmount)
                {
                    throw new InvalidNumberException("This is invalid as it cannot be below 3", aLevelAmount);
                }
                else if(aLevelAmount > maxALevelAmount)
                {
                    throw new InvalidNumberException("This is invalid as it cannot be above 5", aLevelAmount);
                }
            }
            catch(InvalidNumberException e)
            {
                System.err.println(e.getMessage());
            }
        } while(aLevelAmount < minALevelAmount || aLevelAmount > maxALevelAmount);

        //Once these criteria is met, the A level subjects entered are stored in an ArrayList which stores each subject and then
        //parses the whole list into a private String variable which stores them as well using the setter I made in the Student class.
        int subjectNumber = 1;

        //List for storing all the subjects.
        ArrayList<String> aLevelSubjectNamesList = new ArrayList<String>();

        //This for loop keeps repeating until the amount entered achieved has been achieved.
        scanner.nextLine();
        for (int i = 0; i < aLevelAmount; i++)
        {
            String subjectNameRequest = "Enter the name of subject " + subjectNumber+ ": (50 characters):";
            //This do while loop keeps repeating until the subject entered is not empty and the while loop within it
            //keeps going until it is not above 50 characters.
            do
            {
                System.out.println(subjectNameRequest);
                aLevelSubjectName = scanner.nextLine();
                while(aLevelSubjectName.length() > forenameAndSurnameAndSubjectNameLength)
                {
                    System.out.println(characterLengthCheckValidationMessage);
                    System.out.println(subjectNameRequest);
                    aLevelSubjectName = scanner.nextLine();
                }
            } while(aLevelSubjectName.isEmpty());
            aLevelSubjectNamesList.add(aLevelSubjectName);
            subjectNumber++;
        }

        //This turns the A-levels subject array list into a string and sets this private variable value in the
        //student class. This is done so that it's file can be read correctly.
        String storeALevels = aLevelSubjectNamesList.toString();
        setALevelSubjectArray(storeALevels);

        //This variable is used to store the A-level grade entered.
        String gradeEntered = "";

        //List for storing all the grades.
        ArrayList<String> aLevelGradesList = new ArrayList<String>();

        int numberGrade = 0;

        //This for loop keeps recurring until it's been through every single subject entered. The do-while in it
        // keeps going until the entered grade is an actual A-level grade.
        for(int i = 0; i < aLevelAmount; i ++)
        {
            do
            {
                String aLevelGradeRequest = "Please enter the grade " + getForename() + " scored for " + aLevelSubjectNamesList.get(numberGrade) + " (A*, A, B, C, D, E, NC)";
                System.out.println(aLevelGradeRequest);
                gradeEntered = scanner.nextLine().toUpperCase();
            } while(!gradeEntered.equals("A*") && !gradeEntered.equals("A") && !gradeEntered.equals("B") && !gradeEntered.equals("C") && !gradeEntered.equals("D") && !gradeEntered.equals("E") && !gradeEntered.equals("NC"));
            aLevelGradesList.add(gradeEntered);
           numberGrade++;
        }

        //This grades list sets the private grades array list in the Student class so that it can be used later on in the UcasCalculator class.
        setUcasCalculatorResults(aLevelGradesList);

        //This turns the A-levels grades array list into a string and sets this private variable value in the
        //student class. This is done so that it's file can be read correctly.
        String storeGrades = aLevelGradesList.toString();
        setALevelGrades(storeGrades);

        //This do-while loop keeps repeating until the university name entered is not left null, and it is not above 100 characters.
        //Once it has met these criteria, it is stored in the private university name variable using the setter I made in the Student class.
        String universityNameEntryRequest = "Please enter the name of " + getForename() + "'s university (100 characters max):";
        do
        {
            System.out.println(universityNameEntryRequest);
            setUniversityName(scanner.nextLine());

            while(getUniversityName().length() > universityAndDegreeNamesLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(universityNameEntryRequest);
                setUniversityName(scanner.nextLine());
            }
        } while(getUniversityName().isEmpty());

        //This do-while loop keeps repeating until the degree name entered is not left null, and it is not above 100 characters.
        //Once it has met these criteria, it is stored in the private degree name variable using the setter I made in the Student class.
        String degreeNameEntryRequest = "Please enter the name of " + getForename() + "'s degree (100 characters max):";
        do
        {
            System.out.println(degreeNameEntryRequest);
            setDegreeName(scanner.nextLine());

            while (getDegreeName().length() > universityAndDegreeNamesLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(degreeNameEntryRequest);
                setDegreeName(scanner.nextLine());
            }
        } while (getDegreeName().isEmpty());

        //This do-while loop keeps repeating until the student ID entered is not left null, and it is not above 10 characters.
        //Once it has met these criteria, it is stored in the private student ID variable using the setter I made in the Student class.
        //Because different universities have various styles of student IDs, I decided to keep it a string so that it can be
        //inclusive of this fact.
        String studentIdEntryRequest = "Please enter " + getForename() + "'s student ID (10 characters max):";
        do
        {
            System.out.println(studentIdEntryRequest);
            setUniversityStudentID(scanner.nextLine());

            while(getUniversityStudentID().length() >studentIdLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(studentIdEntryRequest);
                setUniversityStudentID(scanner.nextLine());
            }
        } while(getUniversityStudentID().isEmpty());

        //This do-while loop uses the getIntegerFromUser method to ensure an integer is entered.
        //From there it uses custom exceptions to ensure that the year number entered is not above or below the given range
        //of 1-10. Once these criteria is met, it is stored in the private degree time length variable using the setter I made
        //in the Student class.
        int enteredDegreeTimeLength = 0;
        int minTimeLength = 1;
        int maxTimeLength = 10;
        String degreeTimeLengthEntryRequest = "Please enter how long it will take " + getForename() + " to complete studying " + getDegreeName()  + " in years (1-10):";
        do
        {
            enteredDegreeTimeLength = getIntegerFromUser(degreeTimeLengthEntryRequest, scanner);
            scanner.nextLine();
            setDegreeTimeLength(enteredDegreeTimeLength);
            try
            {
                if(enteredDegreeTimeLength <= minTimeLength)
                {
                    throw new InvalidNumberException("This is invalid as the year number entered is less that 1", enteredDegreeTimeLength);
                }
                else if(enteredDegreeTimeLength > maxTimeLength)
                {
                    throw new InvalidNumberException("This is invalid as research shows that a degree does not take any longer than 10 years", enteredDegreeTimeLength);
                }
            }
            catch(InvalidNumberException e)
            {
                System.err.println(e.getMessage());
            }
        } while(enteredDegreeTimeLength < minTimeLength || enteredDegreeTimeLength > maxTimeLength);

        //This do-while loop uses the getIntegerFromUser method to ensure an integer is entered.
        //From there it uses custom exceptions to ensure that the age entered is not above or below the given range
        //of 18-129 (following Gmail's approach). Once these criteria is met, it is stored in the private degree time
        // length variable using the setter I made in the Student class.
        int enteredAge = 0;
        int minAge = 18;
        int maxAge = 129;
        String userAgeEntryRequest = "Enter " + getForename() + "'s age:";
        do
        {
            enteredAge = getIntegerFromUser(userAgeEntryRequest, scanner);
            scanner.nextLine();
            setUserAge(enteredAge);
            try
            {
                if(enteredAge < minAge)
                {
                    throw new InvalidNumberException("This is invalid as the entered age is not above 18", enteredAge);
                }
                else if(enteredAge > maxAge)
                {
                    throw new InvalidNumberException("This is invalid as the entered age is too old", enteredAge);
                }
            }
            catch(InvalidNumberException e)
            {
                System.err.println(e.getMessage());
            }
        } while(enteredAge < minAge || enteredAge > maxAge);

        //Sets an ID for a student using a randomly generated number.
        int maxRandomValue = 1000000;
        Random ran = new Random();
        setSystemStudentId(ran.nextInt(maxRandomValue));
    }

    //This abstract method uses a switch statement so that if the user enters 1 for a full time student then they're
    //registered as one without further details asked. After this, it gets all the basic details and writes a
    //full-time student txt file.
    @Override
    public void studentOccupation(int studentType)
    {
        switch(studentType)
        {
            case 1:
                setOccupation("Full-time student");
                System.out.println("Full-time student successfully registered. " + getForename() + " has been assigned student number: " + getSystemStudentId());
                System.out.println("\n(Press Enter)");
                break;
        }
        WriteFullTimeStudentFile.writeFullTimeStudentToFile(getSystemStudentId(), getForename(), getSurname(), getALevelSubjects(), getALevelGrades(), getUniversityName(), getDegreeName(), getOccupation(), getUniversityStudentID(), getDegreeTimeLength(), getUserAge());
    }

    //This method uses a while loop and the scanner.hasNextInt() to ensure that the user entered a valid integer and if not
    //a datatype prompt is outputted to them. Once it is correct, it returns the integer.
    public int getIntegerFromUser(String prompt, Scanner scanner)
    {
        System.out.println(prompt);
        while(!scanner.hasNextInt())
        {
            scanner.nextLine();
            System.out.println(dataTypeCheckValidationMessage);
            System.out.println(prompt);
        }
        return scanner.nextInt();
    }
}
