package StudentFurtherInformationClasses;

public class AgeAfterDegree
{
    public void userAgeAfterDegree(int age, int timeLength, String forename, String degreeName, String universityName)
    {
        int ageAfter = ageAfter(age, timeLength);
        System.out.println(forename + " will be " + ageAfter + " years old when they have finished studying " + degreeName + " at " + universityName + ".\n");
    }

    //This method adds the years of their degree to their age and prints out the results to the user using the degree and
    //university name as well.
    public int ageAfter(int userAge, int timeLength)
    {
        return userAge + timeLength;
    }
}
