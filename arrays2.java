package assignment;

import java.util.Arrays;
import java.util.Scanner;

public class NumberMissed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array (consecutive integers):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int[] NumberMissed = findMissingNumbers(arr);
        System.out.println("Missing numbers: " + Arrays.toString(NumberMissed));
    }

    public static int[] findMissingNumbers(int[] arr1) {
        if (arr1.length <= 1) {
            return new int[0];
        }

        Arrays.sort(arr1);
        int expected = arr1[0];
        int Count = 0;
        int[] NumberMissed = new int[arr1[arr1.length - 1] - arr1[0] + 1];

        for (int num : arr1) {
            while (expected < num) {
                NumberMissed[Count] = expected;
                Count++;
                expected++;
            }
            expected++;
        }

        return Arrays.copyOf(NumberMissed, Count);
    }
}
