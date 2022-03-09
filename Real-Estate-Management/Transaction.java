import java.util.Scanner;

/**
 * Purpose: To manage business methods related to Transactions 
 * Who created: Kim Ngan
 * Date created: March 8th 2022 
 * Version: 1.0
 */

public class Transaction {

    //1. Attributes
    protected String codeOfTransaction; 
    protected int date;
    protected int month; 
    protected int year;
    protected float unitPrice;  
    protected float area; 
    protected float amount;
    
    //2. Getter, setter methods
    public String getCodeOfTransaction() {
        return codeOfTransaction;
    }
    public void setCodeOfTransaction(String codeOfTransaction) {
        this.codeOfTransaction = codeOfTransaction;
    }

    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice; 
    }

    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }

    public float getAmount() {
        return amount; 
    }

    //3. Constructor methods
    public Transaction() {

    }

    public Transaction(String codeOfTransaction, int date, int month, int year, float area) {
        this.codeOfTransaction = codeOfTransaction;
        this.date = date;
        this.month = month;
        this.year = year;
        this.area = area;
    }

    //4. Input, output methods
    public void input(Scanner scan) {
        System.out.print("Enter code of transaction: ");
        this.codeOfTransaction = scan.nextLine();

        System.out.print("Enter date: ");
        this.date = Integer.parseInt(scan.nextLine());

        System.out.print("Enter month: ");
        this.month = Integer.parseInt(scan.nextLine()); 

        System.out.print("Enter year: ");
        this.year = Integer.parseInt(scan.nextLine());

        System.out.print("Enter area (unit: square meters): ");
        this.area = Float.parseFloat(scan.nextLine());
    }

    public void output() {
        System.out.print("Code: " + this.codeOfTransaction + 
                            "\t Date/Month/Year : " + this.month + "/" + this.date + "/" + this.year +  
                            "\t Area: " + this.area + " square meters");
    }

    //5. Business methods 
    //Calculate the amount 
    public void calculateAmount() {
        this.amount = 0; 
    }

    //Update unit price according to type of land or house  
    public void updateUnitPrice() {
        this.unitPrice = 0; 
    }
}