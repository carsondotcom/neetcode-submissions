class Solution {

    data class Cell(val row: Int, val col: Int)

    fun dfs(cell: Cell, visited: HashSet<Cell>, grid: Array<IntArray>): Int {
        val upperBoundary = 0
        val leftBoundary = 0
        val lowerBoundary = grid.lastIndex
        val rightBoundary = grid[0].lastIndex

        if (cell.row > lowerBoundary 
        || cell.row < upperBoundary
        || cell.col < leftBoundary
        || cell.col > rightBoundary
        || grid[cell.row][cell.col] == 0
        || visited.contains(cell)) {
            // This cell is ocean or has already been visted
            return 0
        } else {
            val rightNeighbor = Cell(cell.row, cell.col + 1)
            val downNeighbor = Cell(cell.row + 1, cell.col)
            val leftNeighbor = Cell(cell.row, cell.col - 1)
            val upNeighbor = Cell(cell.row - 1, cell.col)
            
            visited.add(cell)
            return 1 + dfs(rightNeighbor, visited, grid) + dfs(leftNeighbor, visited, grid) + dfs(upNeighbor, visited, grid) + dfs(downNeighbor, visited, grid)
        }
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val visited = HashSet<Cell>()
        var maxArea = 0

        for (row in 0..grid.lastIndex) {
            for (col in 0..grid[0].lastIndex) {
                val cell = Cell(row, col)
                val islandArea = dfs(cell, visited, grid)
                maxArea = maxOf(islandArea, maxArea)
            }
        }
        return maxArea
    }
}
