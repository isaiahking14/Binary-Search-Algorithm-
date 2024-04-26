import java.io.*;
import java.util.*;

public class BinarySearch {
    private static int[] arr;
    private static int occurrence;
    
    public static void main(String[] args) throws FileNotFoundException {
        load();
        System.out.println(search(arr, 51216352));
        System.out.println(occurrence);
        System.out.println();

        System.out.println(search(arr, 198313119));
        System.out.println(occurrence);
        System.out.println();

        System.out.println(search(arr, 196614208));
        System.out.println(occurrence);
        
    }

    // simple load method to fill array with numbers from file
    private static void load() throws FileNotFoundException {
                                // change for file
        File number = new File("numbers.txt");
        Scanner scan = new Scanner(number);
        int index_count = 0;
        while (scan.hasNextInt()){
            index_count++;
            scan.nextInt();
        }
        arr = new int[index_count];
        scan.close();
        
        Scanner scan2 = new Scanner(number);
        index_count = -1;
        while (scan2.hasNextInt()){
            index_count++;
            arr[index_count] = scan2.nextInt();
        }
        scan2.close();
    }

    // basic binary search over pre sorted array
    // splits given index parameters in half, and either goes 
    private static int search(int[] arr, int value) {
        int low = 0; // init lowest index 
        int high = arr.length - 1; // init highest index
        occurrence = 0;
        while (low <= high) { // while there are indexes to be searched
            occurrence++;
            int mid = (low + high) / 2; // lowest + highest / 2 to get the middle of the 2
            int guess = arr[mid]; 
            if (guess == value){
                return mid;
            }
            else if (guess > value) { // sets highest index to the index under the guess if the
                high = mid - 1;     // guess is greater than the value being searched for
            }
            else { // sets lowest index to the guess + 1 if the guess is lower than
                low = mid + 1; // the index searched for
            }
        }
        return -1; // returns index -1 to signal that the value wasn't found
    }
    
    
}
