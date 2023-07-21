class Solution {
    public ListNode swapPairs(ListNode header) {
        if(header == null || header.next == null)return header;
        ListNode d = new ListNode(0), a;
        d.next = header;
        a=d;
        while(header!=null&&header.next!=null) {
            a.next = header.next;
            header.next = header.next.next;
            a.next.next = header;
            a = a.next.next;
            header =  header.next;
        }
        return d.next;
    }
}
