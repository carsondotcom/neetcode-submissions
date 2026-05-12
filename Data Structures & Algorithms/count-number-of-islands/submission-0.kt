class Solution {

    data class Cell(val row: Int, val col: Int)

    fun getNeighborsForCell(cell: Cell): HashSet<Cell> {
        return hashSetOf<Cell>(
            Cell(cell.row - 1, cell.col),
            Cell(cell.row, cell.col + 1),
            Cell(cell.row + 1, cell.col),
            Cell(cell.row, cell.col - 1)
            )
    }

    fun breadthFirstSearch(cell: Cell, visited: HashSet<Cell>, grid: Array<CharArray>) {
        val queue = ArrayDeque<Cell>()
        queue.addLast(cell)
        
        while (!queue.isEmpty()) {
            val currentCell = queue.removeFirst()
            visited.add(currentCell)
            val currentNeighbors = getNeighborsForCell(currentCell)

            for (neighbor in currentNeighbors) {
                if (neighbor.row in 0..grid.lastIndex 
                && neighbor.col in 0..grid[0].lastIndex
                && grid[neighbor.row][neighbor.col] == '1'
                && !visited.contains(neighbor)) {
                    queue.addLast(neighbor)
                    visited.add(neighbor)
                }
            }
            
        } 
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var numIslands = 0
        val visited = HashSet<Cell>()

        for (row in 0..grid.lastIndex) {
            for (col in 0..grid[0].lastIndex) {
                val cell = Cell(row, col)
                if (grid[row][col] == '1' && !visited.contains(cell)) {
                    breadthFirstSearch(cell, visited, grid)
                    numIslands++
                }
            }
        }
        return numIslands
    }
}
