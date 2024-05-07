package StudentClasses;
import java.util.Scanner;
import java.util.ArrayList;
public abstract class Student
{
    //Private variables used to store the student data.
    private String _forename, _surname;
    private String _aLevelSubjects, _aLevelGrades;
    private String _universityName, _degreeName;
    private String _occupation, _universityStudentID, _onlinePlatform;
    private int _daysInAWeek, _systemStudentId, _degreeTimeLength, _userAge;
    //This private ArrayList isn't used to store data for the file, but it is necessary for the functionality
    // in the UcasCalculator class to work.
    private ArrayList <String> _ucasCalculatorResults = new ArrayList<>();

    //Encapsulation: getters used to retrieve the student data outside of this abstract class.
    public String getForename() {return _forename;}
    public String getSurname() {return _surname;}
    public String getALevelSubjects () {return _aLevelSubjects;}
    public String getALevelGrades () {return _aLevelGrades;}
    public String getUniversityName() {return _universityName;}
    public String getDegreeName() {return _degreeName;}
    public String getOccupation() {return _occupation;}
    public String getUniversityStudentID() {return _universityStudentID;}
    public String getOnlinePlatform() {return _onlinePlatform;}
    public int getDaysInAWeek() {return _daysInAWeek;}
    public int getSystemStudentId() {return _systemStudentId;}
    public int getDegreeTimeLength() {return _degreeTimeLength;}
    public int getUserAge() {return _userAge;}
    public ArrayList <String> getUcasCalculatorResults() {return _ucasCalculatorResults;}

    //Encapsulation: setters used to modify the data to be stored in these private variables.
    public void setForename(String forename) {this._forename = forename;}
    public void setSurname(String surname) {this._surname = surname;}
    public void setALevelSubjectArray(String aLevelSubjects) {this._aLevelSubjects = aLevelSubjects;}
    public void setALevelGrades(String aLevelGrades) {this._aLevelGrades= aLevelGrades;}
    public void setUniversityName(String universityName) {this._universityName = universityName;}
    public void setDegreeName(String degreeName) {this._degreeName = degreeName;}
    public void setOccupation(String occupation) {this._occupation = occupation;}
    public void setUniversityStudentID(String universityStudentID) {this._universityStudentID = universityStudentID;}
    public void setOnlinePlatform(String onlinePlatform) {this._onlinePlatform = onlinePlatform;}
    public void setDaysInAWeek(int daysInAWeek) {this._daysInAWeek = daysInAWeek;}
    public void setSystemStudentId(int systemStudentId) {this._systemStudentId = systemStudentId;}
    public void setDegreeTimeLength(int degreeTimeLength) {this._degreeTimeLength = degreeTimeLength;}
    public void setUserAge(int userAge) {this._userAge = userAge;}
    public void setUcasCalculatorResults(ArrayList <String> ucasCalculatorResults) { this._ucasCalculatorResults = ucasCalculatorResults;}

    //This is a normal method that is only overwritten in the FullTimeStudent java class.
    public void createStudent() {}

    //This abstract method is mandatory in all the student classes. It is designed to take a studentType integer which it then uses in other
    //classes in a switch statement to set the student entered the right occupation (i.e. full-time, part-time or online) and ask them the
    //right questions.
    public abstract void studentOccupation(int studentType);

    //This scanner is declared globally in this class so that it can be repeated in all other classes and this helped me to avoid errors that come with having many scanners.
    Scanner scanner = new Scanner(System.in);

    //This method is used for reading the files. It returns the occupation of the file entered and this allows it to choose how the software reads the file.
    //For example, it looks and outputs the daysInAWeek for a part-time student, and it looks for an onlinePlatform for an online student.
    public String findOccupation()
    {
        return _occupation;
    }

    //This empty constructor is crucial for the FullTimeStudentClass to work.
    public Student(){};

    //Constructor that allows full-time student files to be read.
    public Student(int systemStudentId, String forename, String surname, String aLevelSubjects, String aLevelGrades, String universityName, String degreeName, String occupation, String universityStudentId, int degreeTimeLength, int userAge)
    {
        _systemStudentId = systemStudentId;
        _forename = forename;
        _surname = surname;
        _aLevelSubjects = aLevelSubjects;
        _aLevelGrades = aLevelGrades;
        _universityName = universityName;
        _degreeName = degreeName;
        _occupation = occupation;
        _universityStudentID = universityStudentId;
        _degreeTimeLength = degreeTimeLength;
        _userAge = userAge;
    }

    //Method that prints the basic details for all types of students.
    public void printGeneralDetails()
    {
        System.out.println("\nStudent ID: " + _systemStudentId);
        System.out.println("Full name: " + _forename + " " + _surname);
        System.out.println("A level subjects: " + _aLevelSubjects);
        System.out.println("A level results (in the same order as subjects taken): " + _aLevelGrades);
        System.out.println("University name: " + _universityName);
        System.out.println("Degree name: " + _degreeName);
        System.out.println("Occupation: " + _occupation);
        System.out.println("University student ID: " + _universityStudentID);
        System.out.println("Degree time length: " + _degreeTimeLength + " years");
        System.out.println("Age of student: " + _userAge + " years old");
    }

    //Constructor that allows only part-time student files to be read.
    public Student(int systemStudentId, String forename, String surname, String aLevelSubjects, String aLevelGrades, String universityName, String degreeName, String occupation, String universityStudentId, int degreeTimeLength, int userAge, int daysInAWeek)
    {
        _systemStudentId = systemStudentId;
        _forename = forename;
        _surname = surname;
        _aLevelSubjects = aLevelSubjects;
        _aLevelGrades = aLevelGrades;
        _universityName = universityName;
        _degreeName = degreeName;
        _occupation = occupation;
        _universityStudentID = universityStudentId;
        _degreeTimeLength = degreeTimeLength;
        _userAge = userAge;
        _daysInAWeek = daysInAWeek;
    }

    //This method looks for the daysInAWeek entry for the part-time student.
    public void printPartTimeStudentDetail()
    {
        System.out.println("Number of days in a week: " + _daysInAWeek);
    }

    //Constructor that allows online student files to be read.
    public Student(int systemStudentId, String forename, String surname, String aLevelSubjects, String aLevelGrades, String universityName, String degreeName, String occupation, String universityStudentId, int degreeTimeLength, int userAge, String onlinePlatform)
    {
        _systemStudentId = systemStudentId;
        _forename = forename;
        _surname = surname;
        _aLevelSubjects = aLevelSubjects;
        _aLevelGrades = aLevelGrades;
        _universityName = universityName;
        _degreeName = degreeName;
        _occupation = occupation;
        _universityStudentID = universityStudentId;
        _degreeTimeLength = degreeTimeLength;
        _userAge = userAge;
        _onlinePlatform = onlinePlatform;
    }

    //This method looks for the onlinePlatform entry for the online student.
    public void printOnlineStudentDetail()
    {
        System.out.println("Online platform: " + _onlinePlatform);
    }
}
