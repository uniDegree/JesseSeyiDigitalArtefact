package WriteFileClasses;

//Imports the relevant classes from their associated packages.
import DirectoryClass.Directories;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFullTimeStudentFile
{
    //Using the directory made, it takes into account the basic student details and writes them to a file that is named after it's
    //system generated ID using a try catch statement.
    public static void writeFullTimeStudentToFile(int systemStudentId, String forename, String surname, String subjects, String grades, String universityName, String degreeName, String occupation, String universityStudentId, int degreeTimeLength, int userAge)
    {
        String filePath = systemStudentId + ".txt";
        File file = new File(Directories.DIRECTORY_STUDENT_ACCOUNTS, filePath);

        file.getParentFile().mkdir();

        try
        {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(systemStudentId + "\n");
            bufferedWriter.write(forename + "\n");
            bufferedWriter.write(surname + "\n");
            bufferedWriter.write(subjects + "\n");
            bufferedWriter.write(grades + "\n");
            bufferedWriter.write(universityName + "\n");
            bufferedWriter.write(degreeName + "\n");
            bufferedWriter.write(occupation+ "\n");
            bufferedWriter.write(universityStudentId + "\n");
            bufferedWriter.write(degreeTimeLength + "\n");
            bufferedWriter.write(userAge + "\n");

            bufferedWriter.close();
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
