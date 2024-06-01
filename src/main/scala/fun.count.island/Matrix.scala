package fun.count.island

import scala.util.Random

final class MatrixInitializer(n: Int, m: Int){
  lazy val matrix = Array.ofDim[Int](n, m)

  for (i <- 0 until n) {
    for (j <- 0 until m) {
      matrix(i)(j) = Random.nextInt(2)
    }
  }

  def prettyPrint(): Unit = {
    for (i <- 0 until n) {
      for (j <- 0 until m) {
        print(matrix(i)(j) + " ")
      }
      println()
    }
  }
}
