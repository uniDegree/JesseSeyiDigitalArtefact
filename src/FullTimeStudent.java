import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
        String surnameEntryRequest = "Please enter the surname (50 characters max):";
        String universityNameEntryRequest = "Please enter the name of their university (100 characters max):";
        String studentIdEntryRequest = "Please enter their student ID (10 characters max):";
        String degreeNameEntryRequest = "Please enter the name of their degree (100 characters max):";
        String degreeTimeLengthEntryRequest = "Please enter the time length of their degree in years (1-10):";
        String userAgeEntryRequest = "Please enter their age:";



        //This do while loop keeps repeating until the forename entered is not left null, and it is not above 50 characters.
        //Once it has met these criteria, it is stored in the private forename variable using the setter I made in the Student class.
        int forenameAndSurnameLength = 50;
        int universityAndDegreeNamesLength = 100;
        int studentIdLength = 10;

        do
        {
            System.out.println(forenameEntryRequest);
            setForename(scanner.nextLine());

            while(getForename().length() >forenameAndSurnameLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(forenameEntryRequest);
                setForename(scanner.nextLine());
                System.out.println("\n");
            }
        } while(getForename().isEmpty());

        //This do while loop keeps repeating until the surname entered is not left null, and it is not above 50 characters.
        //Once it has met these criteria, it is stored in the private surname variable using the setter I made in the Student class.
        do
        {
            System.out.println(surnameEntryRequest);
            setSurname(scanner.nextLine());

            while(getSurname().length() >forenameAndSurnameLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(surnameEntryRequest);
                setSurname(scanner.nextLine());
                System.out.println("\n");
            }
        } while(getSurname().isEmpty());

        //This do while loop keeps repeating until the university name entered is not left null, and it is not above 100 characters.
        //Once it has met these criteria, it is stored in the private university name variable using the setter I made in the Student class.
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
        do
        {
            enteredDegreeTimeLength = getIntegerFromUser(degreeTimeLengthEntryRequest, scanner);
            scanner.nextLine();
            setDegreeTimeLength(enteredDegreeTimeLength);
            try
            {
                if(enteredDegreeTimeLength <= minTimeLength)
                {
                    throw new InvalidNumberException("Year number entered was less that 1", enteredDegreeTimeLength);
                }
                else if(enteredDegreeTimeLength > maxTimeLength)
                {
                    throw new InvalidNumberException("Research shows that a degree does not take any longer than 10 years", enteredDegreeTimeLength);
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
        do
        {
            enteredAge = getIntegerFromUser(userAgeEntryRequest, scanner);
            scanner.nextLine();
            setUserAge(enteredAge);
            try
            {
                if(enteredAge < minAge)
                {
                    throw new InvalidNumberException("The entered age has to be above 18", enteredAge);
                }
                else if(enteredAge > maxAge)
                {
                    throw new InvalidNumberException("The age entered is invalid", enteredAge);
                }
            }
            catch(InvalidNumberException e)
            {
                System.err.println(e.getMessage());
            }
        } while(enteredAge < minAge || enteredAge > maxAge);

        //Sets an ID for a student using a randomly generated number.
        Random ran = new Random();
        setSystemStudentId(ran.nextInt(1000000));

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
