package StudentClasses;

import WriteFileClasses.AppendOnlineStudentFile;

public class OnlineStudent extends FullTimeStudent
{
    @Override
    public void studentOccupation(int studentType)
    {
        String onlinePlatformPrompt = "What online platform does " + getForename() + " use for studying " + getDegreeName() + "? (50 characters max)";
        int onlinePlatformLength = 50;
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

        super.studentOccupation(studentType);
        switch (studentType)
        {
            case 3:
                setOccupation("Online student");
                System.out.println("Online student successfully registered. " + getForename() + " has been assigned student number: " + getSystemStudentId());

                break;
        }
        AppendOnlineStudentFile.writeFullTimeStudentToFile(getSystemStudentId(), getForename(), getSurname(), getALevelSubjects(), getALevelGrades(), getUniversityName(), getDegreeName(), getOccupation(), getUniversityStudentID(), getDegreeTimeLength(), getUserAge());
        AppendOnlineStudentFile.appendOnlineTimeStudentToFile(getSystemStudentId(), getOnlinePlatform());
    }
}
