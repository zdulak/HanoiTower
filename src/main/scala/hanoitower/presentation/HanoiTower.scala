package hanoitower.presentation

import hanoitower.core.boards.Board

object HanoiTower {
  def main(args: Array[String]): Unit = {
    val board = new Board(5)
    View.printBoard(board)
    View.printBoard(board.move(0, 2))
  }


}
