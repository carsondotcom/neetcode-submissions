class Solution {
    data class Cell (val row: Int, val col: Int)

    fun orangesRotting(grid: Array<IntArray>): Int {

        val visited = hashSetOf<Cell>()
        val fruitQueue = ArrayDeque<Cell>()
        
        fun isCellInBoundsAndNonEmpty(cell: Cell): Boolean {
            if (cell.row < 0 || cell.row > grid.lastIndex
            || cell.col < 0 || cell.col > grid[0].lastIndex
            || grid[cell.row][cell.col] != 1) {
                return false
            }
            return true
        }

        fun simulateRotting(): Int {
            var minutes = 0
            while (fruitQueue.isNotEmpty()) {
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
                        if (isCellInBoundsAndNonEmpty(neighbor) && !visited.contains(neighbor)) {
                            fruitQueue.add(neighbor)
                            visited.add(neighbor)
                            grid[neighbor.row][neighbor.col] = 2
                        }
                    }
                }
                // only increase minutes if we've actually added new rotten fruit
                if (fruitQueue.isNotEmpty()) {
                    minutes++
                }
            }
            return minutes
        }

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 2) {
                    val rottenFruit = Cell(row, col)
                    fruitQueue.add(rottenFruit)
                    visited.add(rottenFruit)
                }
            }
        }
        val minutes = simulateRotting()
        
        // check result
        for (row in grid) {
            if (row.contains(1)) {
                return -1
            }
        }
        return minutes
    }
}
