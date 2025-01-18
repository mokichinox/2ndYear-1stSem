public class CollegeStudent {
    
    private String firstName, lastName;
    private MyDate enrollmentDate, graduationDate;
    
    public CollegeStudent(String firstName, String lastName, MyDate enrollDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollDate;
        this.graduationDate = new MyDate(enrollmentDate.getYear() + 4, enrollmentDate.getMonth(), enrollmentDate.getDay());
    }
    
    public String getFirstname(){
        return  firstName;
    }
    
    public String getLastname(){
        return lastName;
    }
    
    public MyDate getEnrollmentDate(){
        return enrollmentDate;
    }
    
    public MyDate getGraduationDate(){
        return graduationDate;
    }
    
    public void setFirstname(String firstName){
        this.firstName = firstName;
    }
    public void setLastname(String lastName){
        this.lastName = lastName;
    }
    public void setEnrollmentDate(MyDate enrollmentDate) {
        
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = new MyDate(enrollmentDate.getYear() + 4, enrollmentDate.getMonth(), enrollmentDate.getDay());
    }
    public void setGraduationDate(MyDate graduationDate){
        this.graduationDate = graduationDate;
    }
}
