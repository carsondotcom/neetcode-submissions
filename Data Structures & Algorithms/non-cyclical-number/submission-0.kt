class Solution {
    fun getSumOfDigitsSquared(n: Int): Int {
        val numString = n.toString()
        var sum = 0
        for (char in numString) {
            val digit = char.digitToInt()
            sum += digit * digit
        }
        return sum
    }

    fun isHappy(n: Int): Boolean {
        var sods = getSumOfDigitsSquared(n)
        val seenSums = hashSetOf<Int>(sods)
        while (sods != 1) {
            val newSum = getSumOfDigitsSquared(sods)
            println("sum of squared digits of $sods = $newSum")
            if (seenSums.contains(newSum)) {
                return false
            }
            seenSums.add(newSum)
            sods = newSum
        }
        return true
    }
}
