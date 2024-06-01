package fun.count.island

class MySuite extends munit.FunSuite {
  test("Matrix initialization") {
    val m = new MatrixInitializer(5, 5)
    val counter = new IslandCounter() 
    println("start")
    m.prettyPrint()
    println(counter.countIslands(m.matrix))
    println("after")
    m.prettyPrint()
  }
}
