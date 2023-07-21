import java.util.*;
class Solution{
    
    public static void main(String []argh)
    {
        Scanner s = new Scanner(System.in);
        
        while (s.hasNext()) {
            String ip=s.next();
    while(ip.length() != (ip = ip.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
    System.out.println(ip.isEmpty());
        }
        
    }
}
