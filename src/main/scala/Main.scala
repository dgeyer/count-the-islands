import zio.stream.ZStream
import zio.*
import fun.count.island.*
import MatrixInitializer.*

object Main extends ZIOAppDefault {
  val counter = new IslandCounter()
  def run = ZStream
    .repeatZIO(
      for {
        n <- Random.nextIntBounded(100)
        matrix <- ZIO.succeed(
          new MatrixInitializer(Array.ofDim[Int](n, n)).random()
        )
      } yield matrix
    )
    .forever
    .tap { matrix =>
      for {
        _ <- ZIO.succeed(
          print(s"Matrix ${matrix.length}x${colsLenght(matrix)} ")
        )
        _ <- ZIO.attempt(
          println("Islands count: " + counter.countIslands(matrix))
        )
      } yield ()
    }
    .runDrain
}
