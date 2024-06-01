package fun.count.island

import scala.util.Random

final class MatrixInitializer(val matrix: Array[Array[Int]]) {
  val rows = matrix.length
  val cols = matrix(0).length

  def random(): Array[Array[Int]] = {
    Array.tabulate(rows, cols)((_, _) => Random.nextInt(2))
  }

}
