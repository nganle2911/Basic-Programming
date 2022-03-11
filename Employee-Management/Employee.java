import java.util.Scanner;

/**
 * Purpose: To manage business methods related to Employee
 * Who created: Kim Ngan
 * Date created: 06/03/2022
 * Version: 1.0 
 */
public class Employee {
    
    //unit: millions VND for BASE_SALARY 
    final float BASE_SALARY = (float) 2.3; 

    //1. Attributes
    private String codeOfEmployee; 
    private String nameOfEmployee;
    private String dateOfBirth; 
    private String address; 
    private float coefficient;
    private float salary; 

    //2. Getter, setter methods
    public String getCodeOfEmployee() {
        return codeOfEmployee;
    }
    public void setCodeOfEmployee(String codeOfEmployee) {
        this.codeOfEmployee = codeOfEmployee;
    }

    public String getNameOfEmployee() {
        return nameOfEmployee;
    }
    public void setNameOfEmployee(String nameOfEmployee) {
        this.nameOfEmployee = nameOfEmployee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public float getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient; 
    }

    public float getSalary() {
        return salary;
    }

    //3. Constructor methods
    public Employee() {

    }

    public Employee(String codeOfEmployee, String nameOfEmployee, String dateOfBirth) {
        this.codeOfEmployee = codeOfEmployee;
        this.nameOfEmployee = nameOfEmployee;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(float salary) {
        this.salary = salary;
    }

    public Employee(String codeOfEmployee, String nameOfEmployee, float salary) {
        this.codeOfEmployee = codeOfEmployee;
        this.nameOfEmployee = nameOfEmployee;
        this.salary = salary;
    }

    public Employee(String codeOfEmployee, String nameOfEmployee, String dateOfBirth, String address,
            float coefficient) {
        this.codeOfEmployee = codeOfEmployee;
        this.nameOfEmployee = nameOfEmployee;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.coefficient = coefficient;
    }

    //4. Input, output methods
    public void input(Scanner scan) {
        System.out.print("Enter name of Employee: ");
        this.nameOfEmployee = scan.nextLine();

        System.out.print("Enter code of Employee: ");
        this.codeOfEmployee = scan.nextLine();
        
        System.out.print("Enter date of birth of Employee: ");
        this.dateOfBirth = scan.nextLine();

        System.out.print("Enter address of Employee: ");
        this.address = scan.nextLine();

        System.out.print("Enter the corresponding salary coefficient: ");
        this.coefficient = Float.parseFloat(scan.nextLine()); 

    }

    public void output() {
        System.out.println("Employee - Code: " + this.codeOfEmployee +
                            "\t Name: " + this.nameOfEmployee + 
                            "\t Date of Birth: " + this.dateOfBirth + 
                            "\t Address: " + this.address + 
                            "\t Salary Coefficient: " + this.coefficient + 
                            "\t Salary: " + this.salary + " millions VND");
    }

    //5. Business methods
    //Calculate salary 
    public void calculateSalary() {
        this.salary = this.coefficient * BASE_SALARY; 
    }

    //Format cho nhung con so trong bang 
    private String formatNumCell(Number num) {
        String paddLeft = "%10s"; //%8s : 8 characters 
        String paddRight = "%-15s"; //%-12s : 12 characters (tinh tu ky tu dang sau ky tu thu 8 o tren)
        return String.format(paddLeft, " ") + String.format(paddRight, num) + "|"; //" " : space character 
    }

    //Format cho text trong bang 
    private String formatTextCell(String text) {
        String paddLeft = "%-22s"; //22 characters 
        return String.format(paddLeft, " " + text);
    }

    public void outputRowFormat() {
        String text; 
        text = formatTextCell(this.codeOfEmployee) + "|";
        text += formatTextCell(this.nameOfEmployee) + "|";
        text += formatTextCell(this.dateOfBirth) + "|"; 
        text += formatTextCell(this.address) + "|";
        text += formatNumCell(this.coefficient);
        double slr = Math.round(this.salary * 100.0)/100.0; //lam tron so 2 chu so phan thap phan
        text += formatNumCell(slr) + "|"; 

        System.out.println(text);
    }

}
