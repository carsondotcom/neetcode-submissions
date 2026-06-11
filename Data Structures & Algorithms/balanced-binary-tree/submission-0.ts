/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



class Solution {




    /**
     * @param {TreeNode} root
     * @return {boolean}
     */
    isBalanced(root: TreeNode | null): boolean {
        let isBalanced = true

        function getHeight(root: TreeNode | null): number {
            if (root === null) {
                return 0
            }
            const leftHeight = 1 + getHeight(root.left)
            const rightHeight = 1 + getHeight(root.right)
            if (Math.abs(leftHeight - rightHeight) > 1) {
                isBalanced = false
            }
            return Math.max(leftHeight, rightHeight)
        }
        getHeight(root)
        
        return isBalanced
    }
}
