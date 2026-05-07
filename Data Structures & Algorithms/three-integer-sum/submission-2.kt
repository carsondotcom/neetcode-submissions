class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val validTriplets = mutableListOf<List<Int>>()
        
        // Sorting the array will allow us to use left and right pointers to find the sum
        nums.sort()

        for (i in 0..nums.lastIndex - 2) {
            // rearrange formula -target = l + r
            val target = -nums[i]
            var l = i + 1
            var r = nums.lastIndex

            while (l != r) {
                val result = nums[l] + nums[r]
                when {
                    (result > target) -> r--
                    (result < target) -> l++
                    (result == target) -> {
                        // valid triplet found
                        val triplet = listOf(nums[i], nums[l], nums[r])
                        if (!validTriplets.contains(triplet)) {
                            validTriplets.add(triplet)
                        }
                        // move one pointer to continue evaluation
                        r--
                    }
                }
            }
            
        }
        return validTriplets
    }
}
