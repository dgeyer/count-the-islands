package fun.count.island

class IslandCounter {

  def countIslands(matrix: Array[Array[Int]]): Int = {
    val rows = matrix.length
    val cols = matrix(0).length

    def isSafe(i: Int, j: Int, visited: Array[Array[Boolean]]): Boolean = {
      i >= 0 && i < rows && j >= 0 && j < cols && !visited(i)(j) && matrix(i)(j) == 1
    }

    def dfs(i: Int, j: Int, visited: Array[Array[Boolean]]): Unit = {
      val rowNbr = Array(-1, -1, -1,  0, 0,  1, 1, 1)
      val colNbr = Array(-1,  0,  1, -1, 1, -1, 0, 1)

      visited(i)(j) = true

      for (k <- 0 until 8) {
        if (isSafe(i + rowNbr(k), j + colNbr(k), visited)) {
          dfs(i + rowNbr(k), j + colNbr(k), visited)
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
