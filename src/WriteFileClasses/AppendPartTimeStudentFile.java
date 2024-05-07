package WriteFileClasses;

//Imports the relevant classes from their associated packages.
import DirectoryClass.Directories;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//This inherits from the WriteFullTimeStudentFile because I need to append the same file made to add the extra detail of the
//days in a week.
public class AppendPartTimeStudentFile extends WriteFullTimeStudentFile
{
    //This method takes into account the systemStudentId so that it can find the file already made and from there,
    // it writes in the daysInAWeek entered as well using a try catch statement.
    public static void appendPartTimeStudentToFile(int systemStudentId,int daysInAWeek)
    {
        try
        {
            File filePath = new File(Directories.DIRECTORY_STUDENT_ACCOUNTS + File.separator + systemStudentId + ".txt");
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(daysInAWeek + "\n");
            bufferedWriter.close();
        } catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
