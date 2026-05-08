class Solution {
    fun maxArea(heights: IntArray): Int {
        var maximum = 0
        var bar1  = 0
        var bar2 = heights.lastIndex
        while (bar1 != bar2) {
            // volume = width (distance between bars) * minimum(height1, height2)
            val volume = (bar2 - bar1) * minOf(heights[bar1], heights[bar2])
            if (volume > maximum) {
                maximum = volume
            }
            if (heights[bar1] < heights[bar2]) {
                bar1++
            } else {
                bar2--
            }
        }
        return maximum
    }
}
