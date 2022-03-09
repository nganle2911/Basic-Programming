import java.util.Scanner;

/**
 * Purpose: To manage business methods related to Land Transaction
 * Who created: Kim Ngan
 * Date created: March 8th 2022 
 * Version: 1.0 
 */
public class LandTransaction extends Transaction {
    
    //Constants for unit price 
    //unit: millions VND 
    final float UNIT_PRICE_A = 2.5f;
    final float UNIT_PRICE_B = 3.5f;
    final float UNIT_PRICE_C = 4.5f;  

    //1. Attributes
    private String typeOfLand; 

    //2. Getter, setter methods
    public String getTypeOfLand() {
        return typeOfLand;
    }
    public void setTypeOfLand(String typeOfLand) {
        this.typeOfLand = typeOfLand;
    }
    
    //3. Constructor methods
    public LandTransaction() {

    }

    public LandTransaction(String codeOfTransaction, int date, int month, int year, float area, String typeOfLand) {
        super(codeOfTransaction, date, month, year, area);
        this.typeOfLand = typeOfLand;
    }

    //4. Input, output methods
    @Override
    public void input(Scanner scan) {
        super.input(scan);

        System.out.println("There are 3 types of Land: A, B and C.");
        System.out.print("Please enter a desired type of land: ");
        this.typeOfLand = scan.nextLine(); 
        
        this.updateUnitPrice();
        
    }

    //Update unit price according to type of land 
    @Override
    public void updateUnitPrice() {
        if (this.typeOfLand.equalsIgnoreCase("A")) {
            this.unitPrice = UNIT_PRICE_A;
        } else if (this.typeOfLand.equalsIgnoreCase("B")) {
            this.unitPrice = UNIT_PRICE_B;
        } else {
            this.unitPrice = UNIT_PRICE_C; 
        }
    }

    @Override
    public void output() {
        super.output();
        System.out.println("\t Type of Land: " + this.typeOfLand + 
                            "\t Unit Price: " + this.unitPrice + " millions VND" + 
                            "\t Amount: " + this.amount + " millions VND");
    }

    //5. Business methods
    @Override
    public void calculateAmount() {
        if (this.typeOfLand.equalsIgnoreCase("A")) {
            this.amount = this.area * this.unitPrice * 1.5f; 
        } else {
            this.amount = this.area * this.unitPrice;
        }
    }

    



}
