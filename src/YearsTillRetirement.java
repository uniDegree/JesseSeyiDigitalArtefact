public class YearsTillRetirement
{
    int nationalRetirementAge = 66;
    public void retirementCountdown(Student student)
    {

        //It gets the student's age and uses the TimeTillRetirement method from the DigitalArtefactMethods class.
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
            System.out.println(student.getForename() + " is already " + yearsAfter + " year(s) past the national retirement age of 66 since they are " + age + ".\n" );
        }

    }


    //The national retirement age is 66 years old, so this method takes away the age from 65 and if this is
    // a negative, then the user has passed the retirement age so a congrats message is sent.
    // Otherwise, the user is told how many years they have left until they reach it.
    public int timeTillRetirement(int age)
    {
        return nationalRetirementAge - age;
    }//End of TimeTillRetirement.

    public int timeAfterRetirement(int age)
    {
        return age - nationalRetirementAge;
    }
}
