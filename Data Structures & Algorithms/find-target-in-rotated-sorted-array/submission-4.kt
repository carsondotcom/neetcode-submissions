class Solution {

     fun findMinIndex(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var mid = 0

        while (left <= right) {
            mid = ((right - left) / 2) + left
            when {
                nums[left] <= nums[right] -> return left // segment is sorted, return minimum (leftmost)
                nums[left] <= nums[mid] -> left = mid + 1 // search right
                nums[mid] <= nums[right] -> right = mid // search left
            }
        }

        return mid
    }

    fun search(nums: IntArray, target: Int): Int {
        val rotationPoint = findMinIndex(nums)

        fun binarySearch(target: Int, left: Int, right: Int): Int {
            var left = left
            var right = right

            while (left <= right) {
                val mid = ((right - left) / 2) + left
                when {
                    nums[mid] == target -> return mid
                    nums[mid] > target -> right = mid - 1 // search left
                    nums[mid] < target -> left = mid + 1 // search right
                }
            }
            return -1
        }
        
        // Search second half only if we don't find it in the first half
        var result = binarySearch(target, 0, rotationPoint - 1)
        if (result == -1) {
            return binarySearch(target, rotationPoint, nums.lastIndex)
        }
        return result
    }
}
