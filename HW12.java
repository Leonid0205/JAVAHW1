import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Реализовать алгоритм пирамидальной сортировки (HeapSort)

public class HW12 {
    /** Function creates an array
    * @param size a size of an array
    */  
    public static int[] CraateArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(-10, 10);
        }
        return array;
    }
    /** Function builds a heap
    * @param array an array for building a heap
    */  
    public static void Sorting(int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1 ; i >= 0; i--) {
            pyramid(array, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            pyramid(array, i, 0);
        }
    }
     /** Function transformates to a subtree with a root node index i
    * @param array an array
    * @param n a size of a heap
    * @param i a root node index
    */  
    public static void pyramid(int[] array, int n, int i) {
        int highest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[highest]) {
            highest = left;
        }
        if (right < n && array[right] > array[highest]) {
            highest = right;
        }
        if (highest != i) {
            int temp = array[i];
            array[i] = array[highest];
            array[highest] = temp;
            pyramid(array, n, highest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of an array: ");
        int size = scanner.nextInt();
        System.out.print("\n");
        int[] array1 = CraateArray(size);
        System.out.println(String.format("%-10s= %s", "Initial array ", Arrays.toString(array1)));
        System.out.print("\n");
        Sorting(array1);
        System.out.println(String.format("%-10s= %s", "Sorted array ", Arrays.toString(array1)));
        System.out.print("\n");
        scanner.close();
    }
}
