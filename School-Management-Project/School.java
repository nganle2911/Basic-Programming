import java.util.Scanner;

/**
 * Purpose: To manage business methods related to School 
 * Who created: Kim Ngan
 * Date created: March 11st 2022
 * Version: 1.0 
 */
public class School implements InputOutput {

    //1. Attributes
    private TeacherList objListTeacher; 
    private StudenList objListStudent; 

    //2. Getter, setter methods
    public TeacherList getObjListTeacher() {
        return objListTeacher;
    }
    public void setObjListTeacher(TeacherList objListTeacher) {
        this.objListTeacher = objListTeacher;
    }

    public StudenList getObjListStudent() {
        return objListStudent;
    }
    public void setObjListStudent(StudenList objListStudent) {
        this.objListStudent = objListStudent;
    }

    //3. Constructor methods
    public School() {
        
    }

    //4. Input, output methods 
    @Override
    public void input(Scanner scan) {
        boolean flag = true; 
        Member member; 
        do {
            System.out.println("\nWhich member do you want to add?");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("0. Exit");
            System.out.print("Please choose: ");
            int choose = Integer.parseInt(scan.nextLine()); 

            switch (choose) {
                case 1: //Add teacher 
                    member = new Teacher();
                    member.input(scan);
                    objListTeacher.getListOfTeachers().add((Teacher) member); 
                    break;
                case 2: //Add student 
                    member = new Student();
                    member.input(scan);
                    objListStudent.getListOfStudents().add((Student) member); 
                    break; 
                case 0:
                    flag = false;
                    break; 
                default:
                    System.out.println("Choose only 0/1/2");
            }
        } while (flag);
    }

    @Override
    public void output() {  
        Scanner scan = new Scanner(System.in); 
        System.out.println("\nWhich member do you want to output?");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. All members");
        System.out.print("Please choose: ");
        int choose = Integer.parseInt(scan.nextLine()); 

        switch (choose) {
            case 1: // Output teacher
                System.out.println("\n******************* Teacher List *******************");
                outputTeacherList();
                break;
            case 2:
                System.out.println("\n******************* Student List *******************");
                outputStudentList();
                break;
            case 3:
                System.out.println("\n******************* Teacher List *******************");
                outputTeacherList();
                System.out.println("\n******************* Student List *******************");
                outputStudentList();
                break;
            default:
                System.out.println("\nChoose only 1/2/3");
        }
    }

    private void outputTeacherList() {
        this.objListTeacher.output();
    }

    private void outputStudentList() {
        this.objListStudent.output();
    }

    public void createData() {
        this.objListTeacher = new TeacherList(); 
        this.objListTeacher.createTeacherData();

        this.objListStudent = new StudenList();
        this.objListStudent.createStudentData();
    }

    //5. Business methods 
    //Calculate teaching years of teachers
    public void calculateTeachingYears() {
        this.objListTeacher.calculateTeachingYears();
    }

    //Find teachers having the longest teaching years 
    public void findTeachersWithLongestTeachingYears() {
        this.objListTeacher.findTeachersWithLongestTeachingYears();
    }

    //Find teachers having the teaching years > 5 and their major is "science"
    public void findTeachersHavingOver5YearsAndScience() {
        this.objListTeacher.findTeachersHavingOver5YearsAndScience(); 
    }

    //Calculate the average score of Student
    public void calculateAverageScoreOfStudent() {
        this.objListStudent.calculateAverageScore();
    }

    //Find the highest score of Student
    public float findTheHighestAverageScore() {
        return this.objListStudent.findTheHighestScore(); 
    }

    //Find Students having the highest average score
    public void findStudentsWithTheHighestAverageScore() {
        this.objListStudent.findStudentsWithTheHighestScore();
    }

    //Ranking Students of School
    public void rankingStudentsOfSchool() {
        this.objListStudent.rankingStudentList();
    }

    //Student's name - Bubble sort 
    public void sortStudentName() {
        this.objListStudent.sortStudentName();
        outputStudentList();
    }

    //Sort student's score in descending order - Quick Sort
    public void sortStudentScore() {
        this.objListStudent.sortStudentScore();
        outputStudentList();
    }
    
}
