package WriteFileClasses;

//Imports the relevant classes from their associated packages.
import DirectoryClass.Directories;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//This inherits from the WriteFullTimeStudentFile because I need to append the same file made to add the extra detail of the
//online platform.
public class AppendOnlineStudentFile extends WriteFullTimeStudentFile
{
    //This method takes into account the systemStudentId so that it can find the file already made and from there,
    // it writes in the onlinePlatform entered as well using a try catch statement.
    public static void appendOnlineTimeStudentToFile(int systemStudentId,String onlinePlatform)
    {
        try
        {
            File filePath = new File(Directories.DIRECTORY_STUDENT_ACCOUNTS + File.separator + systemStudentId + ".txt");
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(onlinePlatform + "\n");
            bufferedWriter.close();
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
