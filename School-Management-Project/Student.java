import java.util.Scanner;

/**
 * Purpose: To manage information related to Student class
 * Who created: Kim Ngan
 * Date created: March 11st 2022
 * Version: 1.0 
 */
public class Student extends Member {
    
    //1. Attributes
    private float math; 
    private float litterature; 
    private float language; 
    private float averageScore; 
    private String ranking; 

    //2. Getter, setter methods
    public float getMath() {
        return math;
    }
    public void setMath(float math) {
        this.math = math;
    }

    public float getLitterature() {
        return litterature;
    }
    public void setLitterature(float litterature) {
        this.litterature = litterature;
    }

    public float getLanguage() {
        return language;
    }
    public void setLanguage(float language) {
        this.language = language;
    }

    public float getAverageScore() {
        return averageScore; 
    }

    public String getRanking() {
        return ranking; 
    }
    
    //3. Constructor methods
    public Student() {

    }
    public Student(String name, int yearOfBirth, String placeOfBirth, String address, float math, float litterature,
            float language) {
        super(name, yearOfBirth, placeOfBirth, address);
        this.math = math;
        this.litterature = litterature;
        this.language = language;
    }
    
    //4. Input, output methods
    @Override
    public void input(Scanner scan) {
        super.input(scan);
        System.out.print("Enter Math's score: ");
        this.math = Float.parseFloat(scan.nextLine());

        System.out.print("Enter Litterature's score: ");
        this.litterature = Float.parseFloat(scan.nextLine());

        System.out.print("Enter Language's score: ");
        this.language = Float.parseFloat(scan.nextLine()); 
    }

    @Override
    public void output() {
        super.output();
        System.out.println("\t Math: " + this.math + 
                            "\t Litterature: " + this.litterature + 
                            "\t Language: " + this.language + 
                            "\t Average Score: " + this.averageScore + 
                            "\t Student's Ranking: " + this.ranking);
    }

    //5. Business methods 
    //Calculate the average score of student
    public void calculateAverageScore() {
        this.averageScore = (float) (Math.round(((this.math + this.litterature + this.language)/3)*100.0)/100.0); 
    }

    //Ranking students
    public void rankingStudent() {
        if (this.averageScore < 5) {
            this.ranking = "Weak"; 
        } else if (this.averageScore >= 5 && this.averageScore < 7) {
            this.ranking = "Average";
        } else if (this.averageScore >= 7 && this.averageScore < 8) {
            this.ranking = "Good";
        } else if (this.averageScore >= 8 && this.averageScore < 9) {
            this.ranking = "Very Good";
        } else {
            this.ranking = "Excellent"; 
        }
    }   
}
