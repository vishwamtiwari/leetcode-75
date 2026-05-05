class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        ListNode prev = null;
        ListNode next;
        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        return head;
    }
}