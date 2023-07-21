import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        int num,sum=0,count=0;
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = scan.nextInt();
        }
        for(int i=0;i<num;i++)
        {
            for(int j=i;j<num;j++)
            {
                sum = 0;
for(int k=i;k<=j;k++)
                {
                    sum+=arr[k];
                   
                }
                 if(sum<0)count++;
            }
        }
        System.out.print(count);
}
