import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("1. Add transaction");
        System.out.println("2. Output all of transactions");
        System.out.println("3. Calculate the total number of transactions for each type");
        System.out.println("4. Calculate the average money of Land transactions");
        System.out.println("5. Output transactions on September 2013");
        System.out.println("0. Exit");
    }

    private static void doMenu(Scanner scan) {
        boolean flag = true; 
        ListOfTransaction transaction = new ListOfTransaction();
        transaction.dummyData();
        transaction.calculateAmountForEachTrans(scan);
        do {
            printMenu();
            System.out.print("Please choose: ");
            int choose = Integer.parseInt(scan.nextLine());
            System.out.println("\n"); 
            
            switch (choose) {
                case 1:
                    transaction.input(scan);
                    break;
                case 2:
                    transaction.output();
                    break;
                case 3:
                    System.out.println("Choose type of transaction to calculate: ");
                    System.out.println("1. Land Transaction");
                    System.out.println("2. House Transaction");
                    System.out.print("Please choose: ");
                    int type = Integer.parseInt(scan.nextLine()); 
                    int totalNum = 0; 
                    switch (type) {
                        case 1:
                            totalNum = transaction.calculateTotalNumOfLandTrans(scan);
                            System.out.println("Total number of land transactions: " + totalNum + " transactions");
                            break;
                        case 2:
                            totalNum = transaction.calculateTotalNumOfHouseTrans(scan);
                            System.out.println("Total number of house transactions: " + totalNum + " transactions");
                            break; 
                    }
                    break;
                case 4: 
                    transaction.calculateAverageMoneyOfLandTrans();
                    System.out.println("The average money of Land transactions: "
                            + transaction.calculateAverageMoneyOfLandTrans() + " millions VND");
                    break;
                case 5:
                    transaction.outputTransactionsOnDemand();
                    break;
                case 0:
                    flag = false;
                    break; 
            }
        } while (flag);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        doMenu(scan);
    }
}
