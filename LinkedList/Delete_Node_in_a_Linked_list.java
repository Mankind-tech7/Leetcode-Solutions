class Solution {
    public void deleteNode(ListNode node) 
    {
        node.val = node.next.val;   // copy next node's value into current
        node.next = node.next.next; // skip the next node (unlink it)
    }
}