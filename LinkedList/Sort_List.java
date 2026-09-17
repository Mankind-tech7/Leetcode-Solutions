class Solution {
    public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null)
            {
                return head;
            }
        ListNode mid=findmiddle(head);
        
        ListNode right=mid.next;
        mid.next=null;
        ListNode left=head;
        
        left=sortList(left);
        right=sortList(right);
        
        return mergesortedList(left, right);
    }
    public ListNode findmiddle(ListNode head) 
    {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergesortedList(ListNode list1, ListNode list2) {
        // Create a dummy node
        ListNode dummyNode = new ListNode(-1, null);

        // Temp pointer to build merged list
        ListNode temp = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            // Choose smaller node
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return head of merged list
        return dummyNode.next;
    }

}