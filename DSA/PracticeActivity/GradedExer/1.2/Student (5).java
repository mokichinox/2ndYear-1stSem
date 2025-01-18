package Main;

public class Student {
    private String lName, fName, course;
    private int[] grades;

    public Student(String lName, String fName, String course, int[] grades){
        this.lName = lName;
        this.fName = fName;
        this.course = course;
        this.grades = grades;
    }

    public String getLName(){
        return lName;
    }

    public String getFName(){
        return fName;
    }

    public String getCourse(){
        return course;
    }

    public int[] getGrades(){
        return grades;
    }

    public void setLName(String lName){
        this.lName = lName;
    }

    public void setFName(String fName){
        this.fName = fName;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public void setGrades(int[] grades){
        this.grades = grades;
    }

    public boolean hasFailingGrade(){
        
        for(int grade : grades){
            if(grade < 75){
                return true;
            }
        }
        return false;
    }

    public double average(){
        double sum = 0;
        for(int grade : grades){
            sum += grade;
        }
        return sum / (double) grades.length;
    }

    public void print(){
        System.out.printf("Name: %s, %s\n", this.lName, this.fName);
        System.out.printf("Course: %s\n", this.course);
        System.out.printf("Average: %.2f\n\n", this.average());
    }

}