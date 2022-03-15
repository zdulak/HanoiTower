package hanoitower.core.traits
import hanoitower.core.boards.Board

trait View {
  def printBoard(board: Board): Unit

}
