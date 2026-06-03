/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        // check for the edge cases - list is empty and list has only one item
        if (intervals.isEmpty() || intervals.size < 2) {
            return true
        }
        
        // Sort the list by start time
        val sorted = intervals.toMutableList()
        sorted.sortBy{it.start}

        // Iterate through list
        val iterator = sorted.listIterator()
        var prev = iterator.next()
        while (iterator.hasNext()) {
            val current = iterator.next()
            if (current.start < prev.end) {
                return false
            }
            prev = current
        }
        return true
    }
}
