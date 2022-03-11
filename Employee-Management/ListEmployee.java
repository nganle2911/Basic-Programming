import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: To manage business methods related to list of employees
 * Who created: Kim Ngan
 * Date created: 07/03/2022
 * Version: 1.0 
 */
public class ListEmployee {

    //1. Attributes
    private ArrayList<Employee> listEmployee; 

    //2. Getter, setter methods
    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(ArrayList<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    //3. Constructor methods
    public ListEmployee() {
         defaultSetting();
    }

    private void defaultSetting() {
        this.listEmployee = new ArrayList<Employee>(); 
    }

    //4. Input, output methods
    public void input(Scanner scan) {
        for (Employee employee : this.listEmployee) {
            employee.input(scan);
        }
    }

    public void addEmployee(Employee employee) {
        this.listEmployee.add(employee);
    }

    public void output() {
        for (Employee employee : this.listEmployee) {
            employee.output();
        }
    }

    //5. Business methods 
    public void calculateSalary() {
        for (Employee employee : this.listEmployee) {
            employee.calculateSalary();
        }
    }
}
