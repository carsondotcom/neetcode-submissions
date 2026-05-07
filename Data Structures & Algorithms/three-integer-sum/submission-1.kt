class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        // Sorting the array will allow us to use left and right pointers to find the sum
        nums.sort()

        val validTriplets = mutableListOf<List<Int>>()
        for (i in 0..nums.lastIndex - 2) {
            val target = -nums[i]
            var l = i + 1
            var r = nums.lastIndex
            var found = false
            while (l != r && !found) {
                if (nums[l] + nums[r] > target) {
                    r--
                }
                else if (nums[l] + nums[r] < target) {
                    l++
                }
                else if (nums[l] + nums[r] == target) {
                    // valid triplet found
                    val triplet = listOf(nums[i], nums[l], nums[r])
                    if (!validTriplets.contains(triplet)) {
                        validTriplets.add(triplet)
                    }
                    r--
                }
            }
        }
        return validTriplets
    }
}
