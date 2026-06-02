class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var maxLength = 0
        val frequencyTable = hashMapOf<Char, Int>()

        for (right in s.indices) {            
            // Add the character at s[right] to the hashSet
            frequencyTable.put(s[right], (frequencyTable.getOrDefault(s[right], 0) + 1))

            fun isSubstringValid(): Boolean {
                // Substring is valid if the frequency of MFC is less than
                // k characters off from the length. i.e. the substring contains
                // k characters or fewer that are not MFC
                val mostFrequentChar = frequencyTable.maxBy{it.value}.key
                return (frequencyTable.getOrDefault(mostFrequentChar, 0) >= (right + 1 - left) - k)
            }

            while (!isSubstringValid()) {
                frequencyTable.put(s[left], (frequencyTable.getOrDefault(s[left], 1) - 1))
                left++
            }

            maxLength = maxOf(right + 1 - left, maxLength)
        }

        return maxLength
    }
}
