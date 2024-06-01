package fun.count.island

import scala.util.Random

enum Direction:
  case Horizontal, Vertical, Diagonal

extension (m: MatrixInitializer)
  def allN(n: Int): Array[Array[Int]] = {
    for (i <- 0 until m.rows; j <- 0 until m.cols) {
      m.matrix(i)(j) = n
    }
    m.matrix
  }

  def byDirection(direction: Direction): Array[Array[Int]] = {
    val randRow = Random.nextInt(m.rows)
    val randCol = Random.nextInt(m.cols)

    allN(0)
    direction match {
      case Direction.Horizontal =>
        m.matrix(randRow) = Array.fill(m.cols)(1)
      case Direction.Vertical =>
        for (k <- 0 until m.rows) {
          m.matrix(k)(randCol) = 1
        }
      case Direction.Diagonal =>
        for (i <- 0 until m.rows; j <- 0 until m.cols) {
          m.matrix(i)(j) = if (i == j) 1 else 0
        }
    }
    m.matrix
  }
