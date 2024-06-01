package fun.count.island

import scala.util.Random
import MatrixInitializer.colsLenght

final class MatrixInitializer(val matrix: Array[Array[Int]]) {
  val rows = matrix.length
  val cols = colsLenght(matrix)

  def random(): Array[Array[Int]] = {
    Array.tabulate(rows, cols)((_, _) => Random.nextInt(2))
  }
}

object MatrixInitializer {
  def prettyPrint(matrix: Array[Array[Int]]): Unit = {
    for (i <- 0 until matrix.length) {
      for (j <- 0 until matrix(0).length) {
        print(matrix(i)(j) + " ")
      }
      println()
    }
  }

  def colsLenght(matrix: Array[Array[Int]]): Int = {
    if (matrix.length > 0) matrix(0).length else 0
  }
}
