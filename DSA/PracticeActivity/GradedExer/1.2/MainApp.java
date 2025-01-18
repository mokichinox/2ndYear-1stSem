import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MainApp {
    public static void main(String[] args) throws IOException{
        //Declaration

        Scanner i = new Scanner(new File("src\\Main\\students"));
        ArrayList<Student> students = new ArrayList<>();
        
        int[] tGrades;
        double hAverage = 0;
        int numFail = 0;
        String lName, fName, course;
        
//------------------------------------------------------------------------------------------
    
        while(i.hasNextLine()){
            tGrades = new int[5];
            lName = i.nextLine();
            fName = i.nextLine();
            course = i.nextLine();

            for (int x = 0; x < 5; x++) {
                tGrades[x] = i.nextInt();
            }
            i.nextLine(); 
            students.add(new Student(lName, fName, course, tGrades));
            
            
            for (Student student : students){
                if (hAverage < student.average()) {
                    hAverage = student.average();
                }
                
                if (student.hasFailingGrade()){
                    numFail++;
                }
            }
        }
//-----------------------------------------------------------------------------------------------
             System.out.println("--------------------------------------------------------------");
            System.out.println("Student(s) with the Highest Grade: ");
            System.out.println("--------------------------------------------------------------");
            for(Student student: students){       //loop for printing students with highest grades
                if (student.average() == hAverage){
                    student.print();
                }
            }
            System.out.println("--------------------------------------------------------------");
            System.out.printf("No. of students with Failing Grades: %d\n", numFail);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Student(s) with Failing Grade: ");
             System.out.println("--------------------------------------------------------------");
            for (Student student : students){           //loop for printing students with failing grades
                if (student.hasFailingGrade()){
                    student.print();
                }
            }
        
        
    }
    
}
