package assignment;

import java.util.Scanner;

public class Singulars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of socks: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the sock pair IDs:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int Count = countSingulars(arr);
        System.out.println("Count of singular socks = " + Count);
    }

    public static int countSingulars(int[] arr) {
        int maxId = getMaxId(arr);
        int[] Freq = new int[maxId + 1];

        // Count the frequency of each sock ID
        for (int sock : arr) {
            Freq[sock]++;
        }

        int sCount = 0;

        // Count the number of singular socks
        for (int fr : Freq) {
            if (fr % 2 == 1) {
                sCount++;
            }
        }

        return sCount;
    }

    public static int getMaxId(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int sock : arr) {
            if (sock > max) {
                max = sock;
            }
        }
        return max;
    }
}
