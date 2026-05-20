class Solution {
    data class Cell (val row: Int, val col: Int)

    fun orangesRotting(grid: Array<IntArray>): Int {

        val fruitQueue = ArrayDeque<Cell>()
        var freshCount = 0
        var minutes = 0
        
        // Helper function to identify rottable fruit
        fun isCellInBoundsAndNonEmpty(cell: Cell): Boolean {
            if (cell.row < 0 || cell.row > grid.lastIndex
            || cell.col < 0 || cell.col > grid[0].lastIndex
            || grid[cell.row][cell.col] != 1) {
                return false
            }
            return true
        }

        // Loop through entire matrix to intialize Queue and Count
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 2) {
                    val rottenFruit = Cell(row, col)
                    fruitQueue.add(rottenFruit)
                }
                if (grid[row][col] == 1) {
                    freshCount++
                }
            }
        }
    
        // Simulate rotting
        while (fruitQueue.isNotEmpty() && freshCount > 0) {
                // work through queue by 'level'
                for (i in 0 until fruitQueue.size) {
                    val cell = fruitQueue.removeFirst()

                    val neighbors = arrayOf(
                        Cell(cell.row + 1, cell.col), // up
                        Cell(cell.row - 1, cell.col), // down
                        Cell(cell.row, cell.col + 1), // right
                        Cell(cell.row, cell.col - 1)  // left
                    )

                    for (neighbor in neighbors) {
                        if (isCellInBoundsAndNonEmpty(neighbor)) {
                            fruitQueue.add(neighbor)
                            grid[neighbor.row][neighbor.col] = 2
                            freshCount--
                        }
                    }
                }
                // only increase minutes if we've actually added new rotten fruit
                if (fruitQueue.isNotEmpty()) {
                    minutes++
                }
            }

        return if (freshCount == 0) minutes else -1
    }
}
