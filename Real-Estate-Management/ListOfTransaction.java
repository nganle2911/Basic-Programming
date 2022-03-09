import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: To manage business methods related to all of list of transactions 
 * Who created: Kim Ngan
 * Date created: March 9th 2022
 * Version: 1.0 
 */

public class ListOfTransaction {

    //1. Attributes
    private ArrayList<Transaction> listTransaction; 
    private int totalNumOfLandTrans; 
    private float totalAmountOfLandTrans; 
    private int totalNumOfHouseTrans; 
    private float totalAmountOfHouseTrans; 
    private float averageMoneyOfLandTrans;

    //2. Getter, setter methods
    public ArrayList<Transaction> getListTransaction() {
        return listTransaction;
    }
    public void setListTransaction(ArrayList<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    } 

    public int getTotalNumOfLandTrans() {
        return totalNumOfLandTrans; 
    }

    public float getTotalAmountOfLandTrans() {
        return totalAmountOfLandTrans; 
    }

    public int getTotalNumOfHouseTrans() {
        return totalNumOfHouseTrans; 
    }

    public float getTotalAmountOfHouseTrans() {
        return totalAmountOfHouseTrans; 
    }

    public float getAverageMoneyOfLandTrans() {
        return averageMoneyOfLandTrans; 
    }
    
    //3. Constructor methods
    public ListOfTransaction() {
        listTransaction = new ArrayList<Transaction>();
    }

    public ListOfTransaction(ArrayList<Transaction> listTransaction) {
        this.listTransaction = listTransaction; 
    }

    //4. Input, output methods
    public void input(Scanner scan) {
        boolean flag = true; 
        Transaction transaction; 
        do {
            System.out.println("1. Enter Land Transaction");
            System.out.println("2. Enter House Transaction");
            System.out.println("0. Exit");
            System.out.print("Please choose: ");
            int choose = Integer.parseInt(scan.nextLine()); 

            switch (choose) {
                case 1: //Land transaction
                    transaction = new LandTransaction();
                    transaction.input(scan);
                    transaction.calculateAmount();
                    listTransaction.add(transaction); //to add this transaction into list transaction
                    break;
                case 2: //House transaction
                    transaction = new HouseTransaction();
                    transaction.input(scan);
                    transaction.calculateAmount();
                    listTransaction.add(transaction);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.print("Please choose only 0/1/2");
            }
        } while (flag);
    }

    public void output() {
        for (Transaction transaction : this.listTransaction) {
            transaction.output();
        }
    }

    //5. Business methods
    //Calculate total NUMBER and total AMOUNT of LAND transactions according to types of land (số lượng giao dịch)
    public void calculateTotalNumOfLandTrans(Scanner scan) {
        this.totalNumOfLandTrans = 0; 
        this.totalAmountOfLandTrans = 0;  
        System.out.println("\nWhich type of land do you want to calculate? Land A, Land B, Land C or all?");
        System.out.println("Enter 'A/B/C/all' to calculate");
        System.out.print("Please enter: ");
        String type = scan.nextLine();
        for (Transaction transaction : this.listTransaction) {
            if (transaction instanceof LandTransaction) {
                if (type.equalsIgnoreCase("a")) {
                    if (((LandTransaction)transaction).getTypeOfLand().equalsIgnoreCase("a")) {
                        this.totalNumOfLandTrans++;
                        this.totalAmountOfLandTrans += transaction.getAmount();
                    }
                } else if (type.equalsIgnoreCase("b")) {
                    if (((LandTransaction)transaction).getTypeOfLand().equalsIgnoreCase("b")) {
                        this.totalNumOfLandTrans++;
                        this.totalAmountOfLandTrans += transaction.getAmount();
                    }
                } else if (type.equalsIgnoreCase("c")) {
                    if (((LandTransaction)transaction).getTypeOfLand().equalsIgnoreCase("c")) {
                        this.totalNumOfLandTrans++;
                        this.totalAmountOfLandTrans += transaction.getAmount();
                    }
                } else {
                    this.totalNumOfLandTrans++;
                    this.totalAmountOfLandTrans += transaction.getAmount(); 
                }
            }
        } 
    }

    //Calculate total NUMBER and total AMOUNT of HOUSE transactions according to types of house (số lượng giao dịch)
    public void calculateTotalNumOfHouseTrans(Scanner scan) {
        this.totalNumOfHouseTrans = 0;
        this.totalAmountOfHouseTrans = 0;  
        System.out.println("\nWhich type of house do you want to calculate? Normal, Premium, or all?");
        System.err.println("Enter 'normal/premium/all' to calculate");
        System.out.print("Please enter: ");
        String type = scan.nextLine(); 
        for (Transaction transaction : this.listTransaction) {
            if (transaction instanceof HouseTransaction) {
                if (type.equalsIgnoreCase("normal")) {
                    if (((HouseTransaction)transaction).getTypeOfHouse().equalsIgnoreCase("normal")) {
                        this.totalNumOfHouseTrans++;
                        this.totalAmountOfHouseTrans += transaction.getAmount();
                    }
                } else if (type.equalsIgnoreCase("premium")) {
                    if (((HouseTransaction)transaction).getTypeOfHouse().equalsIgnoreCase("premium")) {
                        this.totalNumOfHouseTrans++;
                        this.totalAmountOfHouseTrans += transaction.getAmount();
                    }
                } else {
                    this.totalNumOfHouseTrans++;
                    this.totalAmountOfHouseTrans += transaction.getAmount();
                }
            }
        }
    }

    //Calculate the total number of land transaction 
    private int numAllOfLandTrans() {
        int num = 0; 
        for (Transaction transaction : this.listTransaction) {
            if (transaction instanceof LandTransaction) {
                num++; 
            }
        }
        return num; 
    }

    //Calculate the AVERAGE amount of LAND transaction
    public float calculateAverageMoneyOfLandTrans() {
        this.averageMoneyOfLandTrans = 0;
        int num = numAllOfLandTrans();  
        float amountOfLandTrans = 0; 
        for (Transaction transaction : this.listTransaction) {
            if (transaction instanceof LandTransaction) {
                amountOfLandTrans += ((LandTransaction)transaction).getAmount(); 
            }
        }
        this.averageMoneyOfLandTrans = amountOfLandTrans / num; 
        return this.averageMoneyOfLandTrans; 
    } 

    //Output the transactions on demand: September 2013 
    public void outputTransactionsOnDemand() {
        System.out.println("Transactions on Sept, 2013: ");
        for (Transaction transaction : this.listTransaction) {
            if ((transaction.getMonth() == 9) && (transaction.getYear() == 2013)) {
                transaction.output();
            }
        }

    }

    //Calculate the amount for each transaction  
    public void calculateAmountForEachTrans(Scanner scan) {
        for (Transaction transaction : this.listTransaction) {
            if (transaction instanceof LandTransaction) {
                transaction.updateUnitPrice();
                transaction.calculateAmount();
            } else { 
                transaction.updateUnitPrice();
                transaction.calculateAmount();
            }
        }
    }

    public void dummyData() {
        Transaction transaction = new LandTransaction("L01", 15, 5, 2012, 85.3f, "A");
        this.listTransaction.add(transaction);

        transaction = new LandTransaction("L02", 25, 9, 2012, 52.5f, "b");
        this.listTransaction.add(transaction);

        transaction = new LandTransaction("L03", 9, 10, 2012, 105.5f, "c");
        this.listTransaction.add(transaction);

        transaction = new HouseTransaction("H04", 12, 10, 2012, 58, "normal", "12/5 Nguyen Trai");
        this.listTransaction.add(transaction);

        transaction = new HouseTransaction("H05", 24, 12, 2012, 65.5f, "premium", "5 Le Duan");
        this.listTransaction.add(transaction);

        transaction = new HouseTransaction("H06", 05, 3, 2013, 65, "normal", "35/17/1 Nguyen Binh Khiem");
        this.listTransaction.add(transaction);

        transaction = new LandTransaction("L07", 7, 7, 2013, 105, "a");
        this.listTransaction.add(transaction);
        
        transaction = new LandTransaction("L08", 15, 9, 2013, 98, "b");
        this.listTransaction.add(transaction);

        transaction = new HouseTransaction("H09", 23, 9, 2013, 69.7f, "premium", "1 Le Loi");
        this.listTransaction.add(transaction);

        transaction = new HouseTransaction("H10", 28, 9, 2013, 85, "premium", "é Nguyen Du");
        this.listTransaction.add(transaction); 

        transaction = new LandTransaction("L11", 25, 10, 2014, 102, "b");
        this.listTransaction.add(transaction); 
    }
}
