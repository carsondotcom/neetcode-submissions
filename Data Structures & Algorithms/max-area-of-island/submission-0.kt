class Solution {

    data class Cell(val row: Int, val col: Int)

    fun dfs(cell: Cell, visited: HashSet<Cell>, grid: Array<IntArray>): Int {
        val upperBoundary = 0
        val leftBoundary = 0
        val lowerBoundary = grid.lastIndex
        val rightBoundary = grid[0].lastIndex

        println("checking (${cell.row},${cell.col})")

        if (cell.row > lowerBoundary 
        || cell.row < upperBoundary
        || cell.col < leftBoundary
        || cell.col > rightBoundary
        || grid[cell.row][cell.col] == 0
        || visited.contains(cell)) {
            // This cell is ocean or has already been visted

            // debugging
            if (cell.row > lowerBoundary 
            || cell.row < upperBoundary
            || cell.col < leftBoundary
            || cell.col > rightBoundary) {
                println("cell (${cell.row},${cell.col}) is out of bounds")
            } else if (grid[cell.row][cell.col] != 1) {
                println("cell (${cell.row},${cell.col}) is ocean")
            } else if (visited.contains(cell)) {
                println("cell (${cell.row},${cell.col}) has already been visited")
            }
            
            return 0
        } else {
            println("couting cell (${cell.row}, ${cell.col}) = ${grid[cell.row][cell.col]} as land.")
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
        var islandCount = 0

        for (row in 0..grid.lastIndex) {
            for (col in 0..grid[0].lastIndex) {
                val cell = Cell(row, col)
                if (grid[row][col] == 1 && !visited.contains(cell)) {
                    val islandArea = dfs(cell, visited, grid)
                    islandCount++
                    println("island $islandCount has area $islandArea")
                    maxArea = if (islandArea > maxArea) islandArea else maxArea
                }
            }
        }
        return maxArea
    }
}
