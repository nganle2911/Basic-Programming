import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    
    private static void printMenu() {
        System.out.println("\n********************************** COMPANY ABC **********************************");
        System.out.println("\n***************** Please choose the followings actions *****************");
        System.out.println("1. Add Employee");
        System.out.println("2. Output the list of Employee");
        System.out.println("3. Calculate the sum of salary of All Employees");
        System.out.println("4. Output employees having the highest salary in the company");
        System.out.println("0. Exit");
    }

    private static void doMenu(Company company, Scanner scan) {
        boolean flag = true; 
        do {
            printMenu();
            System.out.print("Please choose: ");
            int choose = Integer.parseInt(scan.nextLine());
            System.out.println();
            switch (choose) {
                case 1:
                    Employee employee = new Employee();
                    employee.input(scan);
                    company.addEmployee(employee);
                    break;
                case 2: 
                    company.calculateSalary();
                    company.outputInFormat(company.getListEmployeeOfCompany().getListEmployee());
                    break;
                case 3:
                    float sum = company.sumOfSalaryOfAllEmployees();
                    System.out.printf("Sum of salary of all Employees in the Company: %.2f", sum); 
                    System.out.println(" millions VND");
                    break;
                case 4: 
                    System.out.println("Employees having the highest salary in the company: ");
                    ArrayList<Employee> list = company.employeesHavingHighestSalary();
                    /* for (Employee highestSalaryEmployee : list) {
                        highestSalaryEmployee.output();
                    } */ 
                    company.outputInFormat(list);            
                    break;
                case 0:
                    flag = false;
                    break;
            }
        } while (flag);

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Company company = new Company(); 
        company.input();
        doMenu(company, scan);         
    }
}
