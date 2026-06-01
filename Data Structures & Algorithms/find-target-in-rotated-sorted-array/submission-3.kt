class Solution {

     fun findMinIndex(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var mid = 0

        while (left <= right) {
            mid = ((right - left) / 2) + left

            if (nums[left] <= nums[right]) {
                // the whole range is sorted, just return left
                return left
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

        return mid
    }

    fun search(nums: IntArray, target: Int): Int {
        val rotationPoint = findMinIndex(nums)
        println("rotation index: $rotationPoint")

        fun binarySearch(target: Int, left: Int, right: Int): Int {
            var left = left
            var right = right

            while (left <= right) {
                val mid = ((right - left) / 2) + left
                println("Searching range: [$left, $right] = ${nums.slice(left..right).joinToString()} \t mid: $mid = ${nums[mid]} ")
                if (nums[mid] == target) {
                    return mid
                } else if (nums[mid] > target) {
                    // search left
                    right = mid - 1
                } else if (nums[mid] < target) {
                    // search right
                    left = mid + 1
                }
            }
            return -1
        }

        if (rotationPoint != 0) {
            // one of these searches will return -1, so take the max of the two
            return maxOf(binarySearch(target, 0, rotationPoint - 1), binarySearch(target, rotationPoint, nums.lastIndex))
        } else {
            return binarySearch(target, 0, nums.lastIndex)
        }

    }
}
