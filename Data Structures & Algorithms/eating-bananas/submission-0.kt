class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val maxK = piles.max()
        var minK = maxK

        var left = 1
        var right = maxK

        while (left <= right) {
            // mid value, current speed to test
            var k = ((right - left) / 2) + left
            
            // compute time to eat all piles at this speed
            var hours = 0
            for (x in piles.indices) {
                val timeToEatPile = ceil((piles[x].toDouble() / k.toDouble()))
                hours += timeToEatPile.toInt()
            }

            if (hours <= h) {
                minK = k
                // try the left half - search for a slower eating speed
                right = k - 1
            } else {
                // try the right half - search for a faster eating speed
                left = k + 1
            }
        }

        return minK
    }
}
