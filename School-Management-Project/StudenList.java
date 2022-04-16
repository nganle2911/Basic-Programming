import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Purpose: To manage business methods related to StudentList 
 * Who created: Kim Ngan 
 * Date created: March 11st 2022
 * Version: 1.0 
 */
public class StudenList implements InputOutput {

    //1. Attributes
    private ArrayList<Student> listOfStudents; 

    //2. Getter, setter methods
    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    //3. Constructor methods
    public StudenList() {
        defaultSetting();
    }

    private void defaultSetting() {
        this.listOfStudents = new ArrayList<Student>(); 
    }

    //4. Input, output methods 
    @Override
    public void input(Scanner scan) {
        for (Student student : this.listOfStudents) {
            student.input(scan);
        }
    }

    @Override
    public void output() {
        for (Student student : this.listOfStudents) {
            student.output();
        }        
    }
    
    public void createStudentData() {
        String url = "StudentData.txt"; 
        try {
            FileReader reader = new FileReader(url); 
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line; 
            while ((line = bufferedReader.readLine()) != null) {
                String[] listInfo = line.split(" # "); 
                Student student = new Student(); 

                //Create data for each teacher
                student.setName(listInfo[0]);
                student.setYearOfBirth(Integer.parseInt(listInfo[1]));
                student.setPlaceOfBirth(listInfo[2]);
                student.setAddress(listInfo[3]);
                student.setMath(Float.parseFloat(listInfo[4]));
                student.setLitterature(Float.parseFloat(listInfo[5]));
                student.setLanguage(Float.parseFloat(listInfo[6]));

                //Add teacher to list
                this.listOfStudents.add(student); 
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //5. Business methods 
    //Calculate the average score of student
    public void calculateAverageScore() {
        for (Student student : this.listOfStudents) {
            student.calculateAverageScore();
        }
    }

    //Find the highest average score of Student
    public float findTheHighestScore() {
        float maxScore = 0; 
        for (Student student : this.listOfStudents) {
            if (student.getAverageScore() > maxScore) {
                maxScore = student.getAverageScore(); 
            }
        }
        return maxScore; 
    }

    //Find the students having the same highest average score
    public void findStudentsWithTheHighestScore() {
        float highestScore = findTheHighestScore();
        for (Student student : this.listOfStudents) {
            if (student.getAverageScore() == highestScore) {
                student.output();
            }
        }
    }

    //Ranking Student list 
    public void rankingStudentList() {
        for (Student student : this.listOfStudents) {
            student.rankingStudent();
        }
    }

    //Sort student's name in order ABC according to Bubble sort 
    private void sortStudentNameBubbleSort(ArrayList<Student> studentList) {
        int i;
        int j;
        for (i = 0; i < studentList.size() - 1; i++) {
            for (j = studentList.size() - 1; j > i; j--) {
                Student student1 = studentList.get(j);
                Student student2 = studentList.get(j-1); 
                if (student1.getName().compareToIgnoreCase(student2.getName()) < 0) {
                    Collections.swap(studentList, j, j-1);
                }
            }
        }
    }

    public void sortStudentName() {
        sortStudentNameBubbleSort(this.listOfStudents);
    }
    
    //Sort student's score in descending order according to QuickSort
    private void sortStudentScoreQuickSort(ArrayList<Student> studentList, int left, int right) { 
        int i, j;
        i = left; 
        j = right; 
        Student X = studentList.get((left + right)/2); 
        Student studentI, studentJ; 
        do {
            studentI = studentList.get(i); 
            studentJ = studentList.get(j); 

            while (studentI.getAverageScore() > X.getAverageScore()) { //run the left side
                i++;
                studentI = studentList.get(i); 
            }

            while (studentJ.getAverageScore() < X.getAverageScore()) { //run the right side
                j--;
                studentJ = studentList.get(j); 
            }

            //Swap if wrong position 
            if (i <= j) {
                Student studentTemp = studentI;
                studentList.set(i, studentJ); 
                studentList.set(j, studentTemp);
                i++;
                j--; 
            }
        } while (i < j);
        
        //Recursion left and right sides
        if (left < j) {
            sortStudentScoreQuickSort(studentList, left, j); //run the left side
        }

        if (i < right) {
            sortStudentScoreQuickSort(studentList, i, right); //run the right side 
        }
    }

    public void sortStudentScore() {
        sortStudentScoreQuickSort(this.listOfStudents, 0, this.listOfStudents.size() - 1);
    }
}
