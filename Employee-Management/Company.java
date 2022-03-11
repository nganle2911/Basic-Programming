import java.util.ArrayList;

/**
 * Purpose: To manage business methods related to Company 
 * Who created: Kim Ngan
 * Date created: 07/03/2022
 * Version: 1.0 
 */
public class Company {
    
    //1. Attributes
    private ListEmployee listEmployeeOfCompany;

    //2. Getter, setter methods
    public ListEmployee getListEmployeeOfCompany() {
        return listEmployeeOfCompany;
    }

    public void setListEmployeeOfCompany(ListEmployee listEmployeeOfCompany) {
        this.listEmployeeOfCompany = listEmployeeOfCompany;
    } 

    //3. Constructor methods
    public Company() {
        this.listEmployeeOfCompany = new ListEmployee(); 
    }

    //4. Input, output methods
    //create dummy data 
    public void input() {
        Employee employee = new Employee("EM01", "Linh", "2/11/1993", "23 Nguyen Chi Thanh", 6.20f); 
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM02", "An", "5/6/1993", "113 Le Chi Thanh", 6.20f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM03", "Minh", "7/7/1988", "2/15 Le Hong Phong", 7.28f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM04", "Hung", "1/5/1995", "12a Tran Hung Dao", 6.56f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM05", "Tram", "2/3/1982", "2 Hai Ba Trung", 8.58f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM06", "Mai Anh", "17/6/1990", "15 Nguyen Trai", 7.28f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM07", "Cuong", "5/8/1980", "20 Nguyen Du", 8.58f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM08", "Chien", "4/2/1995", "8 Ta Quang Buu", 6.56f); 
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM09", "Minh Hai", "17/7/1979", "9 Le Hong Phong", 8.58f);
        this.listEmployeeOfCompany.addEmployee(employee);

        employee = new Employee("EM10", "Tran Dung", "24/12/1998", "10 Hong Bang", 6.20f);
        this.listEmployeeOfCompany.addEmployee(employee);
    }

    public void output() {
        this.listEmployeeOfCompany.output();
    }

    //5. Business methods 
    public void addEmployee(Employee employee) {
        this.listEmployeeOfCompany.addEmployee(employee);
    }

    public void calculateSalary() {
        this.listEmployeeOfCompany.calculateSalary();
    }

    //Calculate sum of salary of all employees 
    public float sumOfSalaryOfAllEmployees() {
        float sumOfSalary = 0; 
        for (Employee employee : this.listEmployeeOfCompany.getListEmployee()) {
            sumOfSalary += employee.getSalary(); 
        }
        return sumOfSalary; 
    }

    //Output the employees having the highest salary in the company 
    public ArrayList<Employee> employeesHavingHighestSalary() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        float maxSalary = 0; 
        for (Employee employee : this.listEmployeeOfCompany.getListEmployee()) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }

        //If having many employees who have the same highest salary -> list them all 
        for (Employee employee : this.listEmployeeOfCompany.getListEmployee()) {
            if (employee.getSalary() == maxSalary) {
                list.add(employee); 
            }
        }
        
        return list; 
    }

    //Print results according to the table 
    private void outputLine() {
        System.out.println("=============================================================================================================================================================");
    }

    private String formatCell(String paddLeft, String title, String paddRight) {
        return String.format(paddLeft, " ") + title + String.format(paddRight, " ");
    }

    private void outputRowHeader() {
        String paddString1 = "%2s";
        String paddString2 = "%3s";
        String paddString3 = "%4s"; 
        String paddString4 = "%5s"; 
        String paddString5 = "%7s";
        String paddString6 = "%8s";  

        outputLine();
        String text; 
        text = "||" + formatCell(paddString1, "Order", paddString1) + "|";
        text += formatCell(paddString2, "Code of Employee", paddString2) + "|";
        text += formatCell(paddString2, "Name of Employee", paddString2) + "|";
        text += formatCell(paddString3, "Year of Birth", paddString4) + "|";
        text += formatCell(paddString5, "Address", paddString6) + "|";
        text += formatCell(paddString5, "Coefficient", paddString5) + "|";
        text += formatCell(paddString1, "Salary (millions VND)", paddString1) + "||";
        System.out.println(text);
        outputLine();
    }

    //Xuat so thu tu 
    private void outputCellInOrder(int i) { 
        String paddLeft = "%3s";
        String paddRight = "%-6s";
        String text = "||" + String.format(paddLeft, " ") + String.format(paddRight, " " + i) + "|";
        System.out.print(text);
    }

    public void outputInFormat(ArrayList<Employee> list) {
        outputRowHeader();
        int i = 1;
        for (Employee employee : list) {
            outputCellInOrder(i);
            employee.outputRowFormat();
            i++;
        }
        outputLine();
    }

}
