package assignment;
import java.util.HashSet;
import java.util.Scanner;
class LNode {
    int val;
    LNode next;

    LNode(int val) {
        this.val = val;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements for Linked-List (separated by space):");
        String ip = sc.nextLine();
        LNode head = LinkedListCreation(ip);
        sc.close();

        LNode result = removalOfDuplicates(head);
        System.out.println("Linked-List after removing duplicates: ");
        printing(result);
    }

    public static LNode LinkedListCreation(String input) {
        String[] elements = input.trim().split("\\s+");
        LNode dummy = new LNode(-1);
        LNode cur = dummy;

        for (String element : elements) {
            int value = Integer.parseInt(element);
            cur.next = new LNode(value);
            cur = cur.next;
        }

        return dummy.next;
    }

    public static LNode removalOfDuplicates(LNode head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        LNode current = head;
        LNode prev = null;

        while (current != null) {
            if (set.contains(current.val)) {
                prev.next = current.next; // Skip the duplicate node
            } else {
                set.add(current.val);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    public static void printing(LNode head) {
        LNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println(); // New line after printing the Linked-List
    }
}
