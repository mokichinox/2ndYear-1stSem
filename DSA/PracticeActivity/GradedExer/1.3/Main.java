import java.io.File;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        String lastName, firstName, course;
        char gender;
        int yrLvl;
        double qpi;

        try {
            Scanner i = new Scanner(new File("C:\\Users\\Owner\\IdeaProjects\\DSA\\src\\student.txt"));

            while (i.hasNextLine()) {
                lastName = i.nextLine();
                firstName = i.nextLine();
                gender =Character.toUpperCase(i.nextLine().charAt(0));
                course = i.nextLine();
                yrLvl = Integer.parseInt(i.nextLine());
                qpi = Double.parseDouble(i.nextLine());

                Student student = new Student(lastName, firstName, course, gender, yrLvl, qpi);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        students.sort(new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2) {
                int cCompare = s1.getCourse().compareTo(s2.getCourse());
                if (cCompare != 0) {
                    return cCompare;
                } else {
                    int lNCompare = s1.getLastname().compareTo(s2.getLastname());
                    if (lNCompare != 0) {
                        return lNCompare;
                    } else {
                        return s1.getFirstname().compareTo(s2.getFirstname());
                    }
                }
            }
        });


        System.out.printf("%-40s %-28s %-10s %-10s %-10s\n", "Name", "Course", "Gender", "Year", "QPI");
        System.out.println("-------------------------------------------------------------------------------------------------");


        for (Student student : students) {
            System.out.println(student);
        }
    }
}
