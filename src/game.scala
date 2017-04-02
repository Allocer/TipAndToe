class TicToe {
  def game(): Unit = {
    println("It is Toc and Toe game")
    println("Player 'X', enter cords: ")
  }

  def initializeBoard(board: Array[Array[Int]]): Unit = {
    for (i <- 0 to 3) {
      for (j <- 0 to 3) {
        board(i)(j) = -1
      }
    }
  }

  def printBoard(board: Array[Array[Int]]): Unit = {
    println("----------")
    for (i <- 0 to 3) {
      for (j <- 0 to 3) {
        println(board(i)(j) + " | ")
      }
      println()
      println("----------")
    }
  }

  def checkForWin(board: Array[Array[Int]]): Boolean = {
    return (checkRowsForWin(board) || checkColumnsForWin(board) || checkDiagolnalsForWin(board))
  }

  def checkRowsForWin(board: Array[Array[Int]]): Boolean = {
    for (i <- 0 to 3) {
      if (checkRowCol(board(i)(0), board(i)(1), board(i)(2)) == true) {
        return true
      }
    }
    return false
  }

  def checkColumnsForWin(board: Array[Array[Int]]): Boolean = {
    for (i <- 0 to 3) {
      if (checkRowCol(board(0)(i), board(1)(i), board(2)(i)) == true) {
        return true
      }
    }
    return false
  }

  def checkDiagolnalsForWin(board: Array[Array[Int]]): Boolean = {
    return ((checkRowCol(board(0)(0), board(1)(1), board(2)(2)) == true) || (checkRowCol(board(0)(2), board(1)(1), board(2)(0)) == true))
  }

  def checkRowCol(c1: Int, c2: Int, c3: Int): Boolean = {
    return ((c1 != -1) && (c1 == c2) && (c2 == c3))
  }

  def placeMark(row: Int, col: Int, board: Array[Array[Int]]): Boolean = {
    if (row >= 0 && row < 3) {
      if (col >= 0 && col < 3) {
        if (board(row)(col) == -1) {
          board(row)(col) == 1
          return true
        }
      }
    }
    return false
  }
}

def main(args: Array[String]): Unit = {
  val game = new TicToe()
  val board = Array.ofDim[Int](3, 3)
  game.initializeBoard(board)
  game.placeMark(0,2, board)
  game.printBoard(board)
}
