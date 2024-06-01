package fun.count.island

class IslandCounterTest extends munit.FunSuite {
  val counter = new IslandCounter()
  val m = new MatrixInitializer(Array.ofDim[Int](3, 3))

  test("Count for all 0s is 0") {
    val matrix = m.allN(0)
    assertEquals(counter.countIslands(matrix), 0)
  }

  test("Count for all 1s is 1") {
    val matrix = m.allN(1)
    assertEquals(counter.countIslands(matrix), 1)
  }

  test("Count 1 horizontal island") {
    val matrix = m.byDirection(Direction.Horizontal)
    assertEquals(counter.countIslands(matrix), 1)
  }

  test("Count 1 vertical island") {
    val matrix = m.byDirection(Direction.Vertical)
    assertEquals(counter.countIslands(matrix), 1)
  }

  test("Count 1 diagonal island") {
    val matrix = m.byDirection(Direction.Diagonal)
    assertEquals(counter.countIslands(matrix), 1)
  }

}
