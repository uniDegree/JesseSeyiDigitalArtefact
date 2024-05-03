public class PartTimeStudent extends FullTimeStudent
{
    public void studentOccupation(int studentType)
    {
        String daysInAWeekRequest = "How many days in a week do they have their classes? (1-4)";

        int enteredDaysInAWeek = 0;
        int minDays = 1;
        int maxDays = 4;

        //This do while loop uses the getIntegerFromUser method to ensure an integer is entered.
        //From there it uses custom exceptions to ensure that the days in a week number entered is not above or below the given range
        //of 1-4. Once these criteria is met, it is stored in the private days in a week variable using the setter I made
        //in the Student class.
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

        super.studentOccupation(studentType);
        switch (studentType)
        {
            case 2:
                setOccupation("part-time student");
                System.out.println("Part time student successfully registered. " + getForename() + " has been assigned student number: " + getSystemStudentId());
                break;
        }
    }

}
