import java.util.Scanner;

/**
 * Purpose: To manage business methods related to House Transaction
 * Who created: Kim Ngan
 * Date created: March 9th 2022 
 * Version: 1.0 
 */
public class HouseTransaction extends Transaction {
    
    //unit: millions VND 
    final float UNIT_PRICE_NORMAL = 6.5f; 
    final float UNIT_PRICE_PREMIUM = 12.5f; 

    //1. Attributes
    private String typeOfHouse; 
    private String address; 

    //2. Getter, setter methods
    public String getTypeOfHouse() {
        return typeOfHouse;
    }
    public void setTypeOfHouse(String typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    //3. Constructor methods
    public HouseTransaction() {

    }
    public HouseTransaction(String codeOfTransaction, int date, int month, int year, float area, String typeOfHouse,
            String address) {
        super(codeOfTransaction, date, month, year, area);
        this.typeOfHouse = typeOfHouse;
        this.address = address;
    }
    
    //4. Input, output methods
    @Override
    public void input(Scanner scan) {
        super.input(scan);

        System.out.println("There are 2 types of house: normal and premium.");
        System.out.print("Please enter a derised type of house: ");
        this.typeOfHouse = scan.nextLine(); 

        System.out.print("Enter house's address: ");
        this.address = scan.nextLine(); 

        this.updateUnitPrice();
        
    }

    //Update unit price according to type of house 
    @Override
    public void updateUnitPrice() {
        if (this.typeOfHouse.equalsIgnoreCase("normal")) {
            this.unitPrice = UNIT_PRICE_NORMAL;
        } else {
            this.unitPrice = UNIT_PRICE_PREMIUM; 
        }
    }

    @Override
    public void output() {
        super.output(); 
        System.out.println("\t Type: " + this.typeOfHouse + 
                            "\t Address: " + this.address +
                            "\t Unit price: " + this.unitPrice + " millions VND" + 
                            "\t Amount: " + this.amount + " millions VND");
    }

    //5. Business methods 
    @Override
    public void calculateAmount() {
        if (this.typeOfHouse.equalsIgnoreCase("normal")) {
            this.amount = this.area * this.unitPrice * 0.9f;
        } else {
            this.amount = this.area * this.unitPrice; 
        }
    }
}
