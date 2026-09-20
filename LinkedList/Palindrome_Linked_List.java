class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        if (head == null || head.next == null) return true;

        // 1. find middle (slow ends at middle)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. compare both halves
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}