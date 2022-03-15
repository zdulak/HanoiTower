package hanoitower.core.traits
import hanoitower.core.boards.Board

trait View {
  def printMsg(msg: String): Unit
  def printBoard(board: Board): Unit

}
