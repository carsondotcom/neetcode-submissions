class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxSubArray(nums: number[]): number {
        let right = 0
        let runningSum = 0
        let largestSum = nums[0]

        while (right < nums.length) {

            // discard everything from this point to the left if it's negative
            // if it's negative, it's detracting from the sum
            if (runningSum < 0) {
                runningSum = 0
            }
            runningSum += nums[right]

            largestSum = Math.max(runningSum, largestSum)
            right++
        }
        return largestSum
    }
}
