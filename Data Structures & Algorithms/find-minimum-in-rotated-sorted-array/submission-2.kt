class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var mid = 0

    
        // if left < right, the array is sorted just return left
        if (nums[left] < nums[right]) return nums[left]

        // if it's not there's some point in between left and right where the loop happens
        while (left <= right) {
            println("searching from index $left (nums[$left]=${nums[left]}) to index $right (nums[$right]=${nums[right]})")
            mid = ((right - left) / 2) + left

            if (nums[left] <= nums[right]) {
                // the whole range is sorted, just return left
                return nums[left]
            }
            if (nums[left] <= nums[mid]) {
                // this section of the array is sorted, discard
                left = mid + 1
            }
            if (nums[mid] <= nums[right]) {
                // this section of the array is sorted, discard
                right = mid
            }
        }

        return nums[mid]
    }
}
