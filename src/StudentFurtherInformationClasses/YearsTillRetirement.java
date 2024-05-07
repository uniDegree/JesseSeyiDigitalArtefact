package StudentFurtherInformationClasses;

//Imports the student class from the student class package.
import StudentClasses.Student;

public class YearsTillRetirement
{
    int nationalRetirementAge = 66;
    public void retirementCountdown(Student student)
    {

        //It gets the student's age and uses the timeTillRetirement method to work out how many years they have till they reach retirement
        //if they're below the age of 66. If they are older than this, then it outputs to the user how many years have past the
        // since the student reached this milestone.
        int age = student.getUserAge();
        int yearsUntil;
        int yearsAfter;

        if(age < nationalRetirementAge)
        {
            yearsUntil = timeTillRetirement(age);
            System.out.println(student.getForename() + " has " + yearsUntil + " year(s) to go until they reach the national retirement age.\n");
        }
        else
        {
            yearsAfter = timeAfterRetirement(age);
            System.out.println("At " + student.getUserAge() +  ", " + student.getForename() + " is already " + yearsAfter + " past the national retirement age.");
        }

    }


    //The national retirement age is 66 years old, so this method takes away the age from 66.
    public int timeTillRetirement(int age)
    {
        return nationalRetirementAge - age;
    }//End of TimeTillRetirement.

    //This method subtracts 66 from the student's age.
    public int timeAfterRetirement(int age)
    {
        return age - nationalRetirementAge;
    }
}
