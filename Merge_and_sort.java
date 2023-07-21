package assignment;
import java.util.Scanner;

class LNode {
    int val;
    LNode next;

    LNode(int val) {
        this.val = val;
    }
}

public class Merge_and_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements for Linked-List-1 :");
        String in1 = sc.nextLine();
        LNode list1 = LinkedListCreation(in1);

        System.out.println("Enter elements for Linked-List-2 :");
        String in2 = sc.nextLine();
        LNode list2 = LinkedListCreation(in2);

        sc.close();

        LNode merged = mergedLists(list1, list2);
        LNode sorted = sortedLinkedList(merged);

        System.out.println("Sorted Linked-List: ");
        printLinkedList(sorted);
    }

    public static LNode LinkedListCreation(String input) {
        String[] elements = input.trim().split("\\s+");
        LNode dummy = new LNode(-1);
        LNode current = dummy;

        for (String element : elements) {
            int value = Integer.parseInt(element);
            current.next = new LNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static LNode mergedLists(LNode l1, LNode l2) {
        LNode dummy = new LNode(-1);
        LNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If any list still has remaining elements, append them to the merged list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static LNode sortedLinkedList(LNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LNode slow = head;
        LNode fast = head;
        LNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // Split the list into two halves

        LNode left = sortedLinkedList(head);
        LNode right = sortedLinkedList(slow);

        return mergedLists(left, right);
    }

    public static void printLinkedList(LNode head) {
        LNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print("->");
            }
            cur = cur.next;
        }
        System.out.println(); // New line after printing the Linked-List
    }
}
