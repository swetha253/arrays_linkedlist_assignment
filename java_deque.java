import java.util.*;
    public class test {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Deque<Integer> dq = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            int n = input.nextInt();
            int m = input.nextInt();
            int maximum = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int num= input.nextInt();
                dq.add(num);
                set.add(num);

                if (dq.size() == m) {
                    if (set.size() > maximum)
                        maximum = set.size();

                    int first = dq.remove();
                    if (!dq.contains(first))
                        set.remove(first);
                         }

            }

            System.out.println(maximum);
        
        }

    }
