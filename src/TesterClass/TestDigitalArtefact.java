package TesterClass;

import StudentFurtherInformationClasses.AgeAfterDegree;
import StudentFurtherInformationClasses.UcasCalculator;
import StudentFurtherInformationClasses.YearsTillRetirement;

public class TestDigitalArtefact
{
    //These objects are made here to pull their associated methods for testing.
    AgeAfterDegree ageAfterDegree = new AgeAfterDegree();
    UcasCalculator ucasCalculator = new UcasCalculator();
    YearsTillRetirement yearsTillRetirement = new YearsTillRetirement();
    public static void main(String[] args)
    {
        TestDigitalArtefact runTests = new TestDigitalArtefact();
        System.out.println("The results for the StudentFurtherInformationClasses.AgeAfterDegree method are as follows:");
        runTests.testAgeAfterDegreeMethod();
        System.out.println("\nThe results for the PointCalculator method are as follows:");
        runTests.testPointConversion();
        System.out.println("\nThe results for the TimeTillRetirement method are as follows:");
        runTests.testTimeTillRetirement();
        System.out.println("\nThe results for the TimeAfterRetirement method are as follows:");
        runTests.testTimeAfterRetirement();
    }

    //This parameterised method is used in all the testing classes. It checks that both the predicted output and actual
    //output are equal and if they are it prints out "Test Passed". If not, it not only prints out "Test Failed" but it
    //also compares the 2 results and this allows me (or any other developer) to go back and fix any mistake(s) made.
    public void testResult(int int1, int int2)
    {
        if(int1 == int2)
        {
            System.out.println("Test Passed");
        }
        else
        {
            System.out.println("Test Failed as the real outcome was: " + int1 + ". But the predicted outcome was: " + int2);
        }
    }

    //This test method tests the ageAfterDegree method by checking that it adds the right number of years to the student's
    //age.
    private void testAgeAfterDegreeMethod()
    {
        //This method tests the StudentFurtherInformationClasses.AgeAfterDegree function by inputting some the age and years values
        //and making sure that it adds together and outputs the expected result. For example 18 + 2 should result in 20.
        testResult(ageAfterDegree.ageAfter(18, 2), 20);
        testResult(ageAfterDegree.ageAfter(18, 4), 22);
        testResult(ageAfterDegree.ageAfter(22, 5), 27);
        testResult(ageAfterDegree.ageAfter(50, 9), 59);
        testResult(ageAfterDegree.ageAfter(48, 10), 58);
    }

    //This test method tests the pointCalculator method by making sure it returns the right score associated with each grade.
    private void testPointConversion()
    {
        //These tests make sure that it returns all the values it's supposed to when a valid grade is entered.
        testResult(ucasCalculator.pointConversion("A*"), 56);
        testResult(ucasCalculator.pointConversion("A"), 48);
        testResult(ucasCalculator.pointConversion("B"), 40);
        testResult(ucasCalculator.pointConversion("C"), 32);
        testResult(ucasCalculator.pointConversion("D"), 24);
        testResult(ucasCalculator.pointConversion("E"), 16);
        testResult(ucasCalculator.pointConversion("NC"), 0);

        //These tests make sure that erroneous A-Level grades are dismissed with 0 being returned.
        testResult(ucasCalculator.pointConversion("F"), 0);
        testResult(ucasCalculator.pointConversion("G"), 0);
        testResult(ucasCalculator.pointConversion("H"), 0);
        testResult(ucasCalculator.pointConversion("I"), 0);
        testResult(ucasCalculator.pointConversion("Z"), 0);

        testResult(ucasCalculator.pointConversion("a*"), 0);
        testResult(ucasCalculator.pointConversion("a"), 0);
        testResult(ucasCalculator.pointConversion("b"), 0);
        testResult(ucasCalculator.pointConversion("c"), 0);
        testResult(ucasCalculator.pointConversion("d"), 0);
        testResult(ucasCalculator.pointConversion("e"), 0);

        testResult(ucasCalculator.pointConversion("Superstar result"), 0);
        testResult(ucasCalculator.pointConversion("Terrible result"), 0);
        testResult(ucasCalculator.pointConversion("Anything, who cares"), 0);
    }

    //This test method tests the timeTillRetirement method by checking that it adds the subtracts the student's age
    //from 66 (the national retirement age) correctly.
    private void testTimeTillRetirement()
    {
        testResult(yearsTillRetirement.timeTillRetirement(20), 46);
        testResult(yearsTillRetirement.timeTillRetirement(22), 44);
        testResult(yearsTillRetirement.timeTillRetirement(17), 49);
        testResult(yearsTillRetirement.timeTillRetirement(30), 36);
        testResult(yearsTillRetirement.timeTillRetirement(49), 17);
        testResult(yearsTillRetirement.timeTillRetirement(65), 1);
    }

    //This test method tests the timeAfterRetirement method by checking that it adds the subtracts the student's age
    //from 66 (the national retirement age) correctly.
    private void testTimeAfterRetirement()
    {
        testResult(yearsTillRetirement.timeAfterRetirement(67), 1);
        testResult(yearsTillRetirement.timeAfterRetirement(69), 3);
        testResult(yearsTillRetirement.timeAfterRetirement(75), 9);
        testResult(yearsTillRetirement.timeAfterRetirement(78), 12);
        testResult(yearsTillRetirement.timeAfterRetirement(93), 27);
        testResult(yearsTillRetirement.timeAfterRetirement(99), 33);
    }

}
