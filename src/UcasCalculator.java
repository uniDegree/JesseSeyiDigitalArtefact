import java.util.ArrayList;

public class UcasCalculator
{
    public void calculateUcasPoints(Student student)
    {
        int totalUcas = 0;
        int gradeNumber = 0;
        String userGrade;
        int turn = student.getUcasCalculatorResults().toArray().length;
        //This for loop iterates for the same number of subjects they took. For example, it will repeat 3 times if 3
        //subjects were taken.
        for (int i = 0; i < turn; i++)
        {
            userGrade = student.getUcasCalculatorResults().get(gradeNumber);
            totalUcas += pointConversion(userGrade);
            gradeNumber++;
        }

        //The total score is then outputted to the user.
        System.out.println(student.getForename() + " scored " + totalUcas + " Ucas points.\n");
    }

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
        }//End of switch statement.
    }//End of PointConversion.
}
