package StudentFurtherInformationClasses;

//Imports the student class from the student class package.
import StudentClasses.Student;

public class UcasCalculator
{
    //This uses the array made in the student class to get all the results that were entered.
    public void calculateUcasPoints(Student student)
    {
        int totalUcas = 0;
        int gradeNumber = 0;
        String userGrade;
        int turn = student.getUcasCalculatorResults().toArray().length;

        //This for loop iterates for the same number of subjects they took by using the length of the results array.
        // For example, it will repeat 3 times if 3 subjects were taken.
        for (int i = 0; i < turn; i++)
        {
            userGrade = student.getUcasCalculatorResults().get(gradeNumber);
            totalUcas += pointConversion(userGrade);
            gradeNumber++;
        }

        //The total score is then outputted to the user.
        System.out.println(student.getForename() + " scored " + totalUcas + " Ucas points.\n");
    }

    //This method uses a switch statement to return a score associated with the right grade.
    public int pointConversion (String result)
    {
        switch (result)
        {
            case "A*":
                return 56;
            case "A":
                return 48;
            case "B":
                return 40;
            case "C":
                return 32;
            case "D":
                return 24;
            case "E":
                return 16;
            case "NC":
                return 0;
            default:
                return 0;
        }
    }
}
