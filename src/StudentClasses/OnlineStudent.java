package StudentClasses;

//All the relevant class are imported from their appropriate packages.
import WriteFileClasses.AppendOnlineStudentFile;

//This class inherits from the FullTimeStudent Class so that it can use the createStudent() method and also add a further
//option to the switch statement in the studentOccupation method.
public class OnlineStudent extends FullTimeStudent
{
    //If the user enters 2, then they have chosen to enter a part-time student.
    //From there, they have to enter what online platform they use.
    @Override
    public void studentOccupation(int studentType)
    {
        String onlinePlatformPrompt = "What online platform does " + getForename() + " use for studying " + getDegreeName() + "? (50 characters max)";
        int onlinePlatformLength = 50;

        //This do-while loop keeps repeating until the online platform entered is not left null, and it is not above 50 characters.
        //Once it has met these criteria, it is stored in the private onlinePlatform variable using the setter I made in the Student class.
        do
        {
            System.out.println(onlinePlatformPrompt);
            setOnlinePlatform(scanner.nextLine());

            while (getOnlinePlatform().length() > onlinePlatformLength)
            {
                System.out.println(characterLengthCheckValidationMessage);
                System.out.println(onlinePlatformPrompt);
                setOnlinePlatform(scanner.nextLine());
                System.out.println("\n");;
            }
        } while(getOnlinePlatform().isEmpty());

        //This sets up the new part-time student when 3 is entered.
        super.studentOccupation(studentType);
        switch (studentType)
        {
            case 3:
                setOccupation("Online student");
                System.out.println("Online student successfully registered. " + getForename() + " has been assigned student number: " + getSystemStudentId());

                break;
        }

        //Statements to write a new student file and append it with the extra onlinePlatform detail.
        AppendOnlineStudentFile.writeFullTimeStudentToFile(getSystemStudentId(), getForename(), getSurname(), getALevelSubjects(), getALevelGrades(), getUniversityName(), getDegreeName(), getOccupation(), getUniversityStudentID(), getDegreeTimeLength(), getUserAge());
        AppendOnlineStudentFile.appendOnlineTimeStudentToFile(getSystemStudentId(), getOnlinePlatform());
    }
}
