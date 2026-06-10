/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     */
    getHalfwayNode(head: ListNode | null): ListNode | null {
        let pointer1 = head
        let pointer2 = head.next
        
        while (pointer2 !== null) {
            pointer1 = pointer1.next
            
            pointer2 = pointer2.next
            if (pointer2) {
                pointer2 = pointer2.next
            }
        }
        let middle = pointer1.next
        pointer1.next = null
        return middle
    }

    /** 
     * @param {ListNode} head
     * @return {ListNode} the new head of the list
     */
    reverseList(head: ListNode): ListNode | null {
        let current = head
        let previous = null
        while (current !== null) {
            // store the orginal value of current.next for progression
            let ogNext = current.next

            // reverse the current node's next link
            current.next = previous

            // store this node as the previous
            previous = current

            // carry onto the next node
            current = ogNext
        }
        return previous
    }

    printList(head: ListNode): void {
        let current = head
        while (current !== null) {
            console.log(current.val)
            current = current.next
        }
    }


    /**
     * @param {ListNode} head
     * @return {void}
     */
    reorderList(head: ListNode | null): void {
        let second = this.getHalfwayNode(head)

        second = this.reverseList(second)

        // combine the two halfs
        let first = head
        while (second !== null) {
            let ogNext1 = first.next
            first.next = second
            let ogNext2 = second.next
            second.next = ogNext1

            first = ogNext1
            second = ogNext2
        }
    }
}
