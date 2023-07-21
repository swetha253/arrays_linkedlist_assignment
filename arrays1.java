package assignment;
import java.util.Arrays;
import java.util.Scanner;
public class Arrays1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        try {
            cumulativeMultiple(arr);
            System.out.println("arrNum = " + Arrays.toString(arr));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }

    public static void cumulativeMultiple(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int Multiple = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                Multiple = 0;
                break;
            }
            if (Multiple > Integer.MAX_VALUE / arr[i]) {
                throw new ArithmeticException("Integer overflow occurred.");
            }
            Multiple *= arr[i];
            arr[i] = Multiple;
        }
    }
}



