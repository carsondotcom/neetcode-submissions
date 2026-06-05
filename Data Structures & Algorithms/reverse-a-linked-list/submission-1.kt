/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prevNode: ListNode? = null;
        var ogNext = head
        while (ogNext != null) {
            // traverse to the previous node's original next pointer
            val currNode = ogNext

            // store this node's orginal next pointer
            ogNext = currNode?.next

            // Point this node's next to the previous node
            currNode?.next = prevNode

            // Update prevNode pointer to this one
            prevNode = currNode
        }
        return prevNode
    }
}
