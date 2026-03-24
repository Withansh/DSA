class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // Step 2: move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Step 3: move both pointers
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Step 4: remove the node
        slow.next = slow.next.next;
        
        // Step 5: return new head
        return dummy.next;
    }
}