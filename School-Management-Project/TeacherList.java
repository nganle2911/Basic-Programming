import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: To manage business methods related to TeacherList
 * Who created: Kim Ngan
 * Date created: March 11st 2022
 * Version: 1.0 
 */
public class TeacherList implements InputOutput {

    //1. Attributes 
    private ArrayList<Teacher> listOfTeachers; 

    //2. Getter, setter methods
    public ArrayList<Teacher> getListOfTeachers() {
        return listOfTeachers;
    }
    public void setListOfTeachers(ArrayList<Teacher> listOfTeachers) {
        this.listOfTeachers = listOfTeachers;
    }

    //3. Constructor methods 
    public TeacherList() {
        defaultSetting();
    }

    private void defaultSetting() {
        this.listOfTeachers = new ArrayList<Teacher>(); 
    }
    //4. Input, output methods 
    @Override
    public void input(Scanner scan) {
        for (Teacher teacher : this.listOfTeachers) {
            teacher.input(scan);
        } 
    }

    @Override
    public void output() {
        for (Teacher teacher : this.listOfTeachers) {
            teacher.output();
        }        
    }

    public void createTeacherData() {
        String url = "TeacherData.txt"; 
        try {
            FileReader reader = new FileReader(url); 
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line; 
            while ((line = bufferedReader.readLine()) != null) {
                String[] listInfo = line.split(" # "); 
                Teacher teacher = new Teacher(); 

                //Create data for each teacher
                teacher.setName(listInfo[0]);
                teacher.setYearOfBirth(Integer.parseInt(listInfo[1]));
                teacher.setPlaceOfBirth(listInfo[2]);
                teacher.setAddress(listInfo[3]);
                teacher.setStartYear(Integer.parseInt(listInfo[4]));
                teacher.setMajor(listInfo[5]);

                //Add teacher to list
                this.listOfTeachers.add(teacher); 

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //5. Business methods
    //Calculate teaching years of teacher
    public void calculateTeachingYears() {
        for (Teacher teacher : this.listOfTeachers) {
            teacher.calculateTeachingYears();
        }
    }

    //Find teachers having the longest teaching years 
    public void findTeachersWithLongestTeachingYears() {
        int maxYear = 0; 
        for (Teacher teacher : this.listOfTeachers) {
            if (teacher.getTeachingYears() > maxYear) {
                maxYear = teacher.getTeachingYears(); 
            }
        }

        //List teachers having the same longest teaching years 
        for (Teacher teacher : this.listOfTeachers) {
            if (teacher.getTeachingYears() == maxYear) {
                teacher.output();
            }
        }
    }

    //Find teachers having the teaching years > 5 and their major is "science"
    public void findTeachersHavingOver5YearsAndScience() {
        for (Teacher teacher : this.listOfTeachers) {
            if (teacher.getTeachingYears() > 5 && teacher.getMajor().equalsIgnoreCase("science")) {
                teacher.output();
            }
        }
    }
    
}
