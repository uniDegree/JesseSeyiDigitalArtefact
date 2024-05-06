package ReadFileClasses;

import DirectoryClass.Directories;
import StudentClasses.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class ReadPartTimeStudentFile
{
    public static Student AccessStudentData(int systemStudentId)
    {
        String filePath = Directories.DIRECTORY_STUDENT_ACCOUNTS + File.separator + systemStudentId + ".txt";
        File file = new File(filePath);

        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int systemId = Integer.parseInt(bufferedReader.readLine());
            String forename = bufferedReader.readLine();
            String surname = bufferedReader.readLine();
            String aLevelSubjects = bufferedReader.readLine();
            String aLevelGrades = bufferedReader.readLine();
            String universityName = bufferedReader.readLine();
            String degreeName = bufferedReader.readLine();
            String occupation = bufferedReader.readLine();
            String universityStudentId = bufferedReader.readLine();
            int degreeTimeLength = Integer.parseInt(bufferedReader.readLine());
            int userAge = Integer.parseInt(bufferedReader.readLine());
            int daysInAWeek = Integer.parseInt(bufferedReader.readLine());

            bufferedReader.close();
            return new Student(systemId, forename, surname, aLevelSubjects, aLevelGrades, universityName, degreeName, occupation, universityStudentId, degreeTimeLength, userAge, daysInAWeek) {
                public void studentOccupation(int studentType) {
                    //THis just has to be overwritten because it's an abstract method
                }
            };

        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}

