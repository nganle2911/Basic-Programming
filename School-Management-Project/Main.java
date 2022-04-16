import java.util.Scanner;

public class Main {
    
    private static void printMenu(Scanner scan) {
        System.out.println("\n\n******************* HIGH SCHOOL ABC *******************");
        System.out.println("Please choose the following actions: ");
        System.out.println("1. Add member");
        System.out.println("2. Output member");
        System.out.println("3. List teachers having the longest teaching years");
        System.out.println("4. List teachers having over 5 years of teaching and beloging to 'science' major");
        System.out.println("5. Find the highest average score of student");
        System.out.println("6. List students having the highest average score");
        System.out.println("7. Sort student's average score in descending order");
        System.out.println("8. Sort student's name in order ABC");
        System.out.println("0. Exit");
    }

    private static void doMenu(Scanner scan) {
        boolean flag = true; 
        School school = new School(); 
        school.createData();
        do {
            printMenu(scan);
            System.out.print("Please choose: ");
            int choose = Integer.parseInt(scan.nextLine()); 

            switch (choose) {
                case 1:
                    school.input(scan);
                    break;
                case 2:
                    school.calculateTeachingYears();
                    school.calculateAverageScoreOfStudent();
                    school.rankingStudentsOfSchool();
                    school.output();
                    break; 
                case 3:
                    System.out.println("\nTeachers who have the longest teaching years at school: ");
                    System.out.println("---------------------------------------------------------");
                    school.calculateTeachingYears();
                    school.findTeachersWithLongestTeachingYears();
                    break; 
                case 4:
                    System.out.println("\nTeachers who have over 5 years of teaching and belong to 'science' major: ");
                    System.out.println("---------------------------------------------------------");
                    school.calculateTeachingYears();
                    school.findTeachersHavingOver5YearsAndScience();
                    break;
                case 5:
                    school.calculateAverageScoreOfStudent();
                    school.findTheHighestAverageScore();
                    System.out.println("\nThe highest average score of Student: " + school.findTheHighestAverageScore());
                    break;
                case 6: 
                    System.out.println("\nStudents who have the highest average score: ");
                    System.out.println("---------------------------------------------------------");
                    school.calculateAverageScoreOfStudent();
                    school.rankingStudentsOfSchool();
                    school.findStudentsWithTheHighestAverageScore();
                    break; 
                case 7: 
                    System.out.println("\nList of Students in DESCENDING order of the average score: ");
                    System.out.println("---------------------------------------------------------");
                    school.calculateAverageScoreOfStudent();
                    school.rankingStudentsOfSchool();
                    school.sortStudentScore();
                    break;
                case 8: 
                    System.out.println("\nStudent's name after sort: ");
                    System.out.println("---------------------------------------------------------");
                    school.calculateAverageScoreOfStudent();
                    school.rankingStudentsOfSchool();
                    school.sortStudentName();
                    break;
                case 0:
                    flag = false; 
                    break; 
                default:
                    System.out.println("Choose only from 0 - 8");
            }
        } while (flag);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        doMenu(scan);
    }
}
