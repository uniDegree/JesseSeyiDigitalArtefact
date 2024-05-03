import java.util.Scanner;
public abstract class Student
{
    //Private variables used to store the student data.
    private String _forename, _surname;
    private String _universityName, _degreeName;
    private String _occupation, _universityStudentID, _onlinePlatform;
    private int _daysInAWeek, _systemStudentId, _degreeTimeLength, _userAge;

    //Encapsulation: getters used to retrieve the student data outside of this abstract class.
    public String getForename() {return _forename;}
    public String getSurname() {return _surname;}
    public String getUniversityName() {return _universityName;}
    public String getDegreeName() {return _degreeName;}
    public String getOccupation() {return _occupation;}
    public String getUniversityStudentID() {return _universityStudentID;}
    public String getOnlinePlatform() {return _onlinePlatform;}
    public int getDaysInAWeek() {return _daysInAWeek;}
    public int getSystemStudentId() {return _systemStudentId;}
    public int getDegreeTimeLength() {return _degreeTimeLength;}
    public int getUserAge() {return _userAge;}

    //Encapsulation: setters used to modify the data to be stored in these private variables.
    public void setForename(String forename) {this._forename = forename;}
    public void setSurname(String surname) {this._surname = surname;}
    public void setUniversityName(String universityName) {this._universityName = universityName;}
    public void setDegreeName(String degreeName) {this._degreeName = degreeName;}
    public void setOccupation(String occupation) {this._occupation = occupation;}
    public void setUniversityStudentID(String universityStudentID) {this._universityStudentID = universityStudentID;}
    public void setOnlinePlatform(String onlinePlatform) {this._onlinePlatform = onlinePlatform;}
    public void setDaysInAWeek(int daysInAWeek) {this._daysInAWeek = daysInAWeek;}
    public void setSystemStudentId(int systemStudentId) {this._systemStudentId = systemStudentId;}
    public void setDegreeTimeLength(int degreeTimeLength) {this._degreeTimeLength = degreeTimeLength;}
    public void setUserAge(int userAge) {this._userAge = userAge;}

    public Student() {}
    public void createStudent() {}
    public abstract void studentOccupation(int studentType);

    //This scanner is declared globally in this class so that it can be repeated in all other classes.
    //This helps me to avoid errors that come with numerous scanners.
    Scanner scanner = new Scanner(System.in);
}
