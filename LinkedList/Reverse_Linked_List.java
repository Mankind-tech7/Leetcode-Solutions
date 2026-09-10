class Solution 
{
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // save next node before we lose it
            curr.next = prev;              // reverse the pointer
            prev = curr;                   // move prev forward
            curr = nextTemp;               // move curr forward
        }
        
        return prev; // prev is now the new head
    }
}