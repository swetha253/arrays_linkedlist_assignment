class Solution {
    public ListNode reverseKGroup(ListNode header, int k) {
  if(header==null || k==1) return header;

        ListNode dummy = new ListNode();
        dummy.next = header;

        ListNode cur = dummy,nex = dummy,pre = dummy;

        int count=0;
        while(cur.next!=null){
            cur = cur.next;         
            count++;
        }

        while(count>=k){                 
            cur = pre.next;            
            nex = cur.next;           
            for(int i=1;i<k;i++){        
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;   
            count-=k;                   
        }
        return dummy.next;
    }
}
