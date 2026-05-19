class Solution {

    data class Cell(val row: Int, val col: Int)

    fun islandsAndTreasure(grid: Array<IntArray>) {
        val visited = hashSetOf<Cell>()

        // convenience method for checking OOB
        fun isCellWaterOrOutOfBounds(cell: Cell): Boolean {
            if (cell.row < 0 || cell.row > grid.lastIndex
            || cell.col < 0 || cell.col > grid[0].lastIndex
            || grid[cell.row][cell.col] == -1) {
                return true
            }
            return false
        }

        fun bfs(queue: ArrayDeque<Cell>) {
            var level = 0
            while (!queue.isEmpty()) {
                // process all cells currently in the queue - at this level
                var numInLevel = queue.size
                for (i in 0 until numInLevel) {
                    val cell = queue.removeFirst()
                    
                    grid[cell.row][cell.col] = level

                    // add neighbor to queue only if it is a valid land cell
                    val neighbors = arrayOf(
                        Cell(cell.row - 1, cell.col), // up
                        Cell(cell.row + 1, cell.col), // down
                        Cell(cell.row, cell.col - 1), // left
                        Cell(cell.row, cell.col + 1) // right
                    )
                    for (neighbor in neighbors) {
                        if (!isCellWaterOrOutOfBounds(neighbor) && !visited.contains(neighbor)) {
                            visited.add(neighbor)
                            queue.addLast(neighbor)
                        }
                    }
                    
                }
                // increase level
                level++
            }
        }
        
        val cellQueue = ArrayDeque<Cell>()
        for (row in 0..grid.lastIndex) {
            for (col in 0..grid[row].lastIndex) {
                if (grid[row][col] == 0) {
                    val treasure = Cell(row, col)
                    visited.add(treasure)
                    cellQueue.addLast(treasure)
                }
            }
        }
        bfs(cellQueue)
    }
}
