import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class FullTimeStudent extends Student
{
    String characterLengthCheckValidationMessage = "This entered field is above the given character limit, try again below\n";
    String dataTypeCheckValidationMessage =  "This is not a valid integer, try again below:\n";
    @Override
    public void createStudent()
    {
        //These requests are just user prompts to let them know what to enter for each student.
        //These are stored in variables to avoid me printing the same statements repeatedly as this
        //is prone to mistakes being made.
        String forenameEntryRequest = "Please enter the first name (50 characters max):";

        //This do while loop keeps repeating until the forename entered is not left null, and it is not above 50 characters.
        //Once it has met these criteria, it is stored in the private forename variable using the setter I made in the Student class.
        int forenameAndSurnameAndSubjectNameLength = 50;
        int universityAndDegreeNamesLength = 100;
        int studentIdLength = 10;

        do
        {
            System.out.println(forenameEntryRequest);
            setForename(scanner.nextLine());

            while(getForename().length() >forenameAndSurnameAndSubjectNameLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(forenameEntryRequest);
                setForename(scanner.nextLine());
                System.out.println("\n");
            }
        } while(getForename().isEmpty());

        //This do while loop keeps repeating until the surname entered is not left null, and it is not above 50 characters.
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
                System.out.println("\n");
            }
        } while(getSurname().isEmpty());

        ArrayList<String> aLevelSubjectNamesList = new ArrayList<String>();
        String aLevelSubjectName;
        int aLevelAmount;
        int minALevelAmount = 3;
        int maxALevelAmount = 5;
        String aLevelNumberRequest = "Please enter the number of A-Levels " + getForename() + " took in college (3-5):";

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

        int subjectNumber = 1;

        scanner.nextLine();
        for (int i = 0; i < aLevelAmount; i++)
        {
            String subjectNameRequest = "Enter the name of subject " + subjectNumber+ ": (50 characters):";
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
        }//End of for loop.
        setALevelSubjectArray(aLevelSubjectNamesList);

        ArrayList<String> aLevelGrades = new ArrayList<String>();
        String gradeEntered = "";

        int numberGrade = 0;
        ArrayList <String> subjectsTaken = getALevelSubjectArray();
        for (int i = 0; i < aLevelAmount; i ++)
        {
            do
            {
                String aLevelGradeRequest = "Please enter the grade " + getForename() + " scored for " + subjectsTaken.get(numberGrade) + " (A*, A, B, C, D, E, NC)";
                System.out.println(aLevelGradeRequest);
                gradeEntered = scanner.nextLine().toUpperCase();
            } while(!gradeEntered.equals("A*") && !gradeEntered.equals("A") && !gradeEntered.equals("B") && !gradeEntered.equals("C") && !gradeEntered.equals("D") && !gradeEntered.equals("E") && !gradeEntered.equals("NC"));
           aLevelGrades.add(gradeEntered);
           numberGrade++;
        }
        setALevelGradesArray(aLevelGrades);

        //This do while loop keeps repeating until the university name entered is not left null, and it is not above 100 characters.
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
                System.out.println("\n");
            }
        } while(getUniversityName().isEmpty());

        //This do while loop keeps repeating until the degree name entered is not left null, and it is not above 100 characters.
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
                System.out.println("\n");
            }
        } while (getDegreeName().isEmpty());

        //This do while loop keeps repeating until the student ID entered is not left null, and it is not above 10 characters.
        //Once it has met these criteria, it is stored in the private student ID variable using the setter I made in the Student class.

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
                System.out.println("\n");
            }
        } while(getUniversityStudentID().isEmpty());

        //This do while loop uses the getIntegerFromUser method to ensure an integer is entered.
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



        //This do while loop uses the getIntegerFromUser method to ensure an integer is entered.
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
    @Override
    public void studentOccupation(int studentType)
    {
        switch(studentType)
        {
            case 1:
                setOccupation("full-time student");
                System.out.println("Full time student successfully registered. " + getForename() + " has been assigned student number: " + getSystemStudentId());
                break;
        }
    }

    public int getIntegerFromUser(String prompt, Scanner scanner)
    {
        System.out.println(prompt);
        while(!scanner.hasNextInt())
        {
            System.out.println(dataTypeCheckValidationMessage);
            scanner.nextLine();
            System.out.println(prompt);
        }
        return scanner.nextInt();
    }
}
