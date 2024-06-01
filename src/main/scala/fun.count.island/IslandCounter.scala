package fun.count.island

import MatrixInitializer.colsLenght

class IslandCounter {
  private val RowNext = Array(-1, -1, -1, 0, 0, 1, 1, 1)
  private val ColNext = Array(-1, 0, 1, -1, 1, -1, 0, 1)

  def countIslands(matrix: Array[Array[Int]]): Int = {
    val rows = matrix.length
    val cols = colsLenght(matrix)

    def isUnvisitedOne(
        i: Int,
        j: Int,
        visited: Array[Array[Boolean]]
    ): Boolean = {
      i >= 0 && i < rows && j >= 0 && j < cols && !visited(i)(j) && matrix(i)(
        j
      ) == 1
    }

    def dfs(i: Int, j: Int, visited: Array[Array[Boolean]]): Unit = {
      visited(i)(j) = true

      for (k <- 0 until 8) {
        if (isUnvisitedOne(i + RowNext(k), j + ColNext(k), visited)) {
          dfs(i + RowNext(k), j + ColNext(k), visited)
        }
      }
    }

    val visited = Array.ofDim[Boolean](rows, cols)
    var count = 0

    for (i <- 0 until rows; j <- 0 until cols) {
      if (matrix(i)(j) == 1 && !visited(i)(j)) {
        dfs(i, j, visited)
        count += 1
      }
    }

    count
  }

}
