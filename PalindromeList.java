/* 234 - Check if given linked list is palindrome */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode start = head;
        ListNode mid = head;
        ListNode prev = null;
        
        // implement fast ptr and slow ptr
        while(start != null){
            start = start.next;
            if(start!=null){
                start = start.next;
            }
            mid = mid.next;
        }
    
        //flip the list after mid point
        while(mid!=null){
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }
        
        mid = prev;
        start = head;
        
        // compare 2 halves
        while(mid != null){
            if(mid.val!=start.val){
                return false;
            }
            mid = mid.next;
            start = start.next;
        }
        return true;
    }
}