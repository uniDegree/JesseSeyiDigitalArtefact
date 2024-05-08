package StudentClasses;

//All the relevant classes are imported from their appropriate packages.
import WriteFileClasses.AppendPartTimeStudentFile;
import CustomExceptions.InvalidNumberException;

//This class inherits from the FullTimeStudent Class so that it can use the createStudent() method and also add a further
//option to the switch statement in the studentOccupation method.
public class PartTimeStudent extends FullTimeStudent
{
    //If the user enters 2, then they have chosen to enter a part-time student.
    //From there, they have to enter how many days a week they go to university.
    public void studentOccupation(int studentType)
    {
        String daysInAWeekRequest = "How many days in a week do they have their classes? (1-4)";

        int enteredDaysInAWeek = 0;
        int minDays = 1;
        int maxDays = 4;

        //This do-while loop uses the getIntegerFromUser method to ensure an integer is entered.
        //From there it uses a custom exception to ensure that the days in a week number entered is not above or below the given range
        //of 1-4. Once these criteria is met, it is stored in the private days in a week variable using the setter I made
        //in the StudentClasses.Student class.
        do
        {
            enteredDaysInAWeek = getIntegerFromUser(daysInAWeekRequest, scanner);
            scanner.nextLine();
            setDaysInAWeek(enteredDaysInAWeek);

            try
            {
                if(enteredDaysInAWeek < minDays)
                {
                    throw new InvalidNumberException("This below the minimum value of 1", enteredDaysInAWeek);
                }
                else if(enteredDaysInAWeek > maxDays)
                {
                    throw new InvalidNumberException("This is above the maximum value of 4", enteredDaysInAWeek);
                }
            }
            catch(InvalidNumberException e)
            {
                System.err.println(e.getMessage());
            }
        } while(enteredDaysInAWeek < minDays || enteredDaysInAWeek > maxDays);

        //This sets up the new part-time student when 2 is entered.
        super.studentOccupation(studentType);
        switch (studentType)
        {
            case 2:
                setOccupation("Part-time student");
                System.out.println("Part-time student successfully registered. " + getForename() + " has been assigned student number: " + getSystemStudentId());
                System.out.println("\n(Press Enter)");
                break;
        }

        //Statements to write a new student file and append it with the extra daysInAWeek detail.
        AppendPartTimeStudentFile.writeFullTimeStudentToFile(getSystemStudentId(), getForename(), getSurname(), getALevelSubjects(), getALevelGrades(), getUniversityName(), getDegreeName(), getOccupation(), getUniversityStudentID(), getDegreeTimeLength(), getUserAge());
        AppendPartTimeStudentFile.appendPartTimeStudentToFile(getSystemStudentId(), getDaysInAWeek());
    }

}
