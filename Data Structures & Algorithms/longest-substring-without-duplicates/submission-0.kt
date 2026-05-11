class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var maxLength = 0

        // track which characters are in our current string
        val hashSet = hashSetOf<Char>()
        while (end <= s.lastIndex) {
            if (!hashSet.contains(s[end])) {
                // valid string, update max and increase window
                val substringLength = (end + 1) - start
                maxLength = if (substringLength > maxLength) substringLength else maxLength
                hashSet.add(s[end])
                end++
            } else {
                while (hashSet.contains(s[end])) {
                    // duplicate encountered, shrink window
                    hashSet.remove(s[start])
                    start++
                }
            }
        }
        return maxLength
    }
}
