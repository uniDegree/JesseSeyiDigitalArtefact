package DirectoryClass;

import java.io.File;
public class Directories
{
    //This is the directory for the txt files.
    //It was made static for easy access and it was made final so that it cannot be altered in another classs.
    public static final String DIRECTORY_STUDENT_ACCOUNTS = "src" + File.separator + "StudentAccountTextFiles";
}