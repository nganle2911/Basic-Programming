import java.util.Scanner;

/**
 * Sorting Exercise
 * 
 */
public class SortingExercise {

    final static byte MAX = 100; 
    final static byte MIN = -100; 

    //Enter a number > 0 - the length of array A and B
    public static int enterLen(Scanner scan) {
        int num;
        do {
            System.out.print("Enter a number > 0: ");
            num = Integer.parseInt(scan.nextLine());
        } while (num < 1);
        return num; 
    }

    //Create an array with random values 
    public static int[] createAnArray(int num) {
        int array[] = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
        }
        return array; 
    }

    //Array output 
    public static void arrayOutput(int array[]) {
        for (int item : array) {
            System.out.print(item + "\t");
        }
        System.out.println("\n");
    }

    //Sort array A ascending by Interchange Sort 
    public static int[] sortArrayAscending(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i]; //create a temporary variable 
                    array[i] = array[j];
                    array[j] = temp; 
                }
            }
        }
        return array; 
    }

    //Merge array a and array b in descending order 
    public static int[] mergeAandBinDescending(int a[], int b[]) {
        int c[] = new int[a.length + b.length];
        int i = a.length - 1; //i : index of array a 
        int j = b.length - 1; //j : index of array b 
        for (int k = 0; k < c.length; k++) {
            if (i < 0 || j < 0) {
                if (i < 0) {
                    c[k] = b[j];
                    j--;
                } else {
                    c[k] = a[i];
                    i--;
                }
            } else {
                if (a[i] < b[j]) {
                    c[k] = b[j];
                    j--;
                } else {
                    c[k] = a[i];
                    i--; 
                }
            }
        }
        return c; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Array a 
        System.out.println("Enter n > 0 - the length of array a: ");
        int n = enterLen(scan);
        int a[] = createAnArray(n);
        System.out.println("Array a: ");
        arrayOutput(a);
        
        //Array b
        System.out.println("Enter m > 0 - the length of array b: ");
        int m = enterLen(scan);
        int b[] = createAnArray(m);
        System.out.println("Array b: ");
        arrayOutput(b);
        
        System.out.println("******************* RESULT *******************");
        //Sort array a ascending 
        System.out.println("Sort array a in ASCENDING order: ");
        sortArrayAscending(a);
        arrayOutput(a);
        //Sort array b ascending 
        System.out.println("Sort array b in ASCENDING order: ");
        sortArrayAscending(b);
        arrayOutput(b);
        /* int a[] = {-13, -2, 87};
        int b[] = {-94, -71, -62, -26}; */ 
        //Merge a and b 
        System.out.println("Merge array a and array b in DESCENDING order: ");
        int c[] = mergeAandBinDescending(a, b);
        arrayOutput(c);
    }
}