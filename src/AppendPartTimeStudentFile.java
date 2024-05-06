import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendPartTimeStudentFile extends WriteFullTimeStudentFile
{
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
